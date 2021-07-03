import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    Location location;
    LocationParser locationParser = new LocationParser();
    Location anotherLocation;
    Location nullLocation;

    @BeforeEach
    void initLocation() {
        location = locationParser.parse("Budapest,10.53,40.53");
        anotherLocation = locationParser.parse("Budapest,17.52,47.42");
        nullLocation = locationParser.parse("Budapest,0,0");
    }

    @Test
    void testParse() {
//        Location nullLocation = locationParser.parse("Budapest,0,0");
        assertEquals("Budapest", nullLocation.getName());
        assertEquals(0, nullLocation.getLat());
        assertEquals(0, nullLocation.getLon());
    }

    @Test
    void testOnEquator() {
        assertTrue(locationParser.isOnEquator(nullLocation));
    }

    @Test
    void testOnPrimeMeridian() {
        assertTrue(locationParser.isOnPrimeMeridian(nullLocation));
    }

    @Test
    void testTwoDifferentInstance() {
        assertFalse(location.equals(anotherLocation));
    }

    @Test
    void testDistance() {
        assertEquals(1075, Math.round(location.distanceFrom(location, anotherLocation)));
    }

    @Test
    void testParseTogether() {
        Location nullLocation = locationParser.parse("Budapest,0,0");
        assertAll(
                () -> assertEquals("Budapest", nullLocation.getName()),
                () -> assertEquals(0, nullLocation.getLat()),
                () -> assertEquals(0, nullLocation.getLon())
        );
    }

    @Test
    void LocationOperatorsTest(){

        List<Location> locations = List.of(new Location("Koppenhága",1,1), new Location("Budapest",-1,-2), new Location("Stokholm",4,5));
        assertEquals(List.of("Koppenhága", "Stokholm"), new LocationOperators().filterOnNorth(locations).stream().map(Location::getName).collect(Collectors.toList()));
    }

    @Test
    void LocationLonLatExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> new Location("Budapest", 91, 181));
        assertThrows(IllegalArgumentException.class, () -> new Location("Budapest", -91, -181));
    }


}