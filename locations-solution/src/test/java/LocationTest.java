import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    Location location;
    LocationParser locationParser = new LocationParser();

    @BeforeEach
    void initLocation() {
        location = locationParser.parse("Budapest,0,0");
        System.out.println(location);
    }

    @Test
    void testParse() {

        assertEquals("Budapest", location.getName());
        assertEquals(0, location.getLat());
        assertEquals(0, location.getLon());

    }

    @Test
    void testOnEquator() {
        assertTrue(locationParser.isOnEquator(location));
    }

    @Test
    void testOnPrimeMeridian() {
        assertTrue(locationParser.isOnPrimeMeridian(location));
    }
}