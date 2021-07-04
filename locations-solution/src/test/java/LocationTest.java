import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @ParameterizedTest(name = "isMeridian {0} - location {1}")
    @MethodSource("createLocations")
    void testOnPrimeMeridian(boolean boo, Location location) {
        assertEquals(boo, location.isOnPrimeMeridian());
    }

    @ParameterizedTest(name = "distance {0}")
    @CsvFileSource(resources = "/locations.csv", numLinesToSkip = 2)
    void testDistanceWithCsv(Double distance) {
        assertEquals(distance, Math.round(location.distanceFrom(location, anotherLocation)));
    }

    static Stream<Arguments> createLocations(){
        return Stream.of(
                arguments(true, new Location("Budapest", 0, 0)),
                arguments(false, new Location("London", 1, 1))
        );
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

    @TestFactory
    Stream<DynamicTest> testisEquitor(){
        Location budapest = new Location("Budapest",0,0);
        Location london = new Location("London",0,0);
        return Stream.of(budapest, london)
                .map(item ->
                        DynamicTest.dynamicTest("The " + location.getName() + " is on Equitor",
                                ()-> assertEquals(true, item.isOnEquator())));
    }

    @Test
    void LocationLonLatExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Location("Budapest", 91, 181));
        assertThrows(IllegalArgumentException.class, () -> new Location("Budapest", -91, -181));
    }


}