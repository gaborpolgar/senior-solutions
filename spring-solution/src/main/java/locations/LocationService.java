package locations;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private Location bp = new Location(10L, "Budapest", 5, 5);
    private Location london = new Location(100L, "London", 50, 50);

    private List<Location> locations = List.of(bp, london);

    public List<Location> getLocations() {
        return locations;
    }
}

