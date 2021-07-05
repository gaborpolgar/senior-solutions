package locations;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@NoArgsConstructor
public class LocationService {

    public LocationService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private ModelMapper modelMapper;

    private Location bp = new Location(1L, "Budapest", 5, 5);
    private Location london = new Location(2L, "London", 50, 50);

    private List<Location> locations = Collections.synchronizedList(List.of(bp, london));

    public List<LocationDto> getLocations(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
        List<Location> filtered = locations.stream().
                filter(e-> prefix.isEmpty() || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());
        return modelMapper.map(filtered, targetListType);
    }
}

