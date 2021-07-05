package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationsControllerRestTemplateIT {

    @Autowired
    TestRestTemplate template;

    @Autowired
    LocationService locationService;

    @Test
    void testListLocations(){
        locationService.deleteAllLocations();
        LocationDto locationDto =
        template.postForObject("/locations", new CreateLocationCommand("Amszterdam"), LocationDto.class);

        assertEquals("Amszterdam", locationDto.getName());

        template.postForObject("/locations", new CreateLocationCommand("New York"), LocationDto.class);

        List<LocationDto> locations = template.exchange("/locations",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LocationDto>>() {})
                 .getBody();

        assertThat(locations)
                .extracting(LocationDto::getName)
                .containsExactly("Amszterdam", "New York");
    }

}
