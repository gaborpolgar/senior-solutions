import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {


    @Test
    void testParse() {

        Location location = new LocationParser().parse("Budapest,47.497912,19.040235");

        assertEquals("Budapest", location.getName());
        assertEquals(47.497912, location.getLat());
        assertEquals(19.040235, location.getLon());

    }
}