package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDto> getLocations() {
        return locationService.getLocations();
    }
//        List<LocationDto> locations = locationService.getLocations();
//        StringBuilder sb = new StringBuilder();
//        for (LocationDto location : locations) {
//            sb.append(location.getName()).append(", ");
//        }
//        sb.append(" service");
//        return sb.toString();
//    }

}
