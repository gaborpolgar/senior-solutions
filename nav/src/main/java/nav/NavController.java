package nav;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NavController {

    private final NavService navservice;

    @GetMapping("/types")
    public List<Type> getTypes() {
        return navservice.getTypes();
    }

    @PostMapping("/appointments")
    public void createAppointment(@Valid @RequestBody CreateAppointmentCommand command) {
        System.out.println(command);

    }


}
