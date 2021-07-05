package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDto> getLocations(@RequestParam Optional<String> prefix) {
        return locationService.getLocations(prefix);
    }
//        List<LocationDto> locations = locationService.getLocations();
//        StringBuilder sb = new StringBuilder();
//        for (LocationDto location : locations) {
//            sb.append(location.getName()).append(", ");
//        }
//        sb.append(" service");
//        return sb.toString();
//    }

    @GetMapping("/{id}")
    public LocationDto findLocationById(@PathVariable("id") long id){
        return locationService.findLocationById(id);
    }

    @PostMapping
    public LocationDto createLocation(@RequestBody CreateLocationCommand command){
        return locationService.createLocation(command);
    }

}
