import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

class LocationNestedTest {

    LocationParser parser;
    Location favouriteLocation;
    Location anotherFavouriteLocation;

    @BeforeEach
    void initLocationParser() {
        parser = new LocationParser();
    }
    @Nested
    class nestedClass {

        @BeforeEach
        void initNestedLocationParser() {
            favouriteLocation = new Location("Budapest", 0, 0);
        }

        @Test
        void testOnEquator() {
            assertTrue(parser.isOnEquator(favouriteLocation));
        }

        @Test
        void testOnPrimeMeridian() {
            assertTrue(parser.isOnPrimeMeridian(favouriteLocation));
        }

    }

    @Nested
    class anotherNestedClass {

        @BeforeEach
        void initAnotherNestedLocationParser() {
            anotherFavouriteLocation = new Location("Budapest", 47.497912, 19.040235);
        }

        @Test
        void testOnEquator() {
            assertFalse(parser.isOnEquator(anotherFavouriteLocation));
        }

        @Test
        void testOnPrimeMeridian() {
            assertFalse(parser.isOnPrimeMeridian(anotherFavouriteLocation));
        }


    }


}
