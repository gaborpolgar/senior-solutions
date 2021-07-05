package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationsController {

    private List<Location> locations;

    @GetMapping("/locations")
    @ResponseBody
    public String getLocations(){
        StringBuilder sb = new StringBuilder();
        for (Location location : locations) {
            sb.append(location.getName()).append(", ");
        }
        return sb.toString();
    }

}
