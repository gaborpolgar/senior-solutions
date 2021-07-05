package locations;

import org.modelmapper.internal.bytebuddy.pool.TypePool;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

//    @GetMapping("/{id}")
//    public ResponseEntity findLocationById(@PathVariable("id") long id) {
//        try {
//            return ResponseEntity.ok(locationService.findLocationById(id));
//        } catch (IllegalArgumentException iea) {
//            return ResponseEntity.notFound().build();
//        }

    @GetMapping("/{id}")
    public ResponseEntity findLocationById(@PathVariable("id") long id) {
        return ResponseEntity.ok(locationService.findLocationById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDto createLocation(@Valid @RequestBody CreateLocationCommand command) {
        return locationService.createLocation(command);
    }

    @PutMapping("/{id}")
    public LocationDto updateLocation(@PathVariable("id") long id, @RequestBody UpdateLocationCommand command) {
        return locationService.updateLocation(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable("id") long id) {
        locationService.deleteLocation(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException iae) {
        Problem problem = Problem.builder()
                .withType(URI.create("locations/not-found"))
                .withTitle("Not found")
                .withStatus(Status.NOT_FOUND)
                .withDetail(iae.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleValidException(MethodArgumentNotValidException exception) {
        List<Violation> violations =
                exception.getBindingResult().getFieldErrors().stream()
                .map(fe-> new Violation(fe.getField(), fe.getDefaultMessage()))
        .collect(Collectors.toList());

    Problem problem = Problem.builder()
            .withType(URI.create("locations/not-valid"))
            .withTitle("Validation error")
            .withStatus(Status.BAD_REQUEST)
            .withDetail(exception.getMessage())
            .with("violations", violations)
            .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                    .body(problem);
    }

}

