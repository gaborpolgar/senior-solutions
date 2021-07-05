package locations;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class LocationServiceTest {

    @Test
    void getLocations() {
        assertEquals("[Budapest, London]", new LocationService(new ModelMapper()).getLocations());
    }
}