package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationsController {


    private LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public String getLocations() {
        List<Location> locations = locationService.getLocations();
        StringBuilder sb = new StringBuilder();
        for (Location location : locations) {
            sb.append(location.getName()).append(", ");
        }
        return sb.toString();
    }

}
