package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocationsControllerTest {

    @Mock
    LocationService locationService;

    @InjectMocks
    LocationsController locationsController;

    @Test
    void getLocations() {
        when(locationService.getLocations()).thenReturn(new ArrayList<>(List.of(new Location(10L, "Budapest", 5, 5), new Location(100L, "London", 50, 50))));

        String locations  = locationsController.getLocations();

        assertThat(locations).isEqualTo("Budapest, London, ");
    }
}