import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@LocationOperationsFeatureTest
public class LocationOperationsTest {

    @LocationOperationsFeatureTest
    void LocationOperatorsTest() {

        List<Location> locations = List.of(new Location("Koppenhága", 1, 1), new Location("Budapest", -1, -2), new Location("Stokholm", 4, 5));
        assertEquals(List.of("Koppenhága", "Stokholm"), new LocationOperators().filterOnNorth(locations).stream().map(Location::getName).collect(Collectors.toList()));
    }


}
