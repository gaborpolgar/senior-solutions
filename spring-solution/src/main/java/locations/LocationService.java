package locations;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
//@NoArgsConstructor
public class LocationService {

    public LocationService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private ModelMapper modelMapper;
    private AtomicLong idGenerator = new AtomicLong();

    private List<Location> locations = Collections.synchronizedList(new ArrayList<>(List.of(
            new Location(idGenerator.incrementAndGet(), "Budapest",5,5),
            new Location(idGenerator.incrementAndGet(), "London",3,2)
    )));

    public List<LocationDto> getLocations(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<LocationDto>>() {
        }.getType();
        List<Location> filtered = locations.stream().
                filter(e -> prefix.isEmpty() || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());
        return modelMapper.map(filtered, targetListType);
    }

    public LocationDto findLocationById(long id) {
        return modelMapper.map(locations.stream()
                        .filter(e -> e.getId() == id).findAny()
                        .orElseThrow(() -> new IllegalArgumentException("Location not found" + id)),
                LocationDto.class);
    }

    public LocationDto createLocation(CreateLocationCommand command) {
        Location location = new Location(idGenerator.incrementAndGet(), command.getName(), command.getLat(), command.getLon());
        locations.add(location);
        return modelMapper.map(location, LocationDto.class);
    }

    public LocationDto updateLocation(long id, UpdateLocationCommand command) {
        Location location = locations.stream()
                .filter(e->e.getId() == id)
                .findFirst().orElseThrow(() ->  new IllegalArgumentException("Location not found: " + id));
                location.setName(command.getName());
                return modelMapper.map(location, LocationDto.class);
    }

    public void deleteLocation(long id) {
        Location location = locations.stream()
                .filter(e->e.getId() == id)
                .findFirst().orElseThrow(() ->  new IllegalArgumentException("Location not found: " + id));
        locations.remove(location);
    }

    public void deleteAllLocations(){
        idGenerator = new AtomicLong();
        locations.clear();
    }
}

