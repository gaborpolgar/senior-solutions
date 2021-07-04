import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LocationServiceFileTest {

    @TempDir
    Path tempDir;

    @Test
    void testWriteLocations() throws IOException {
        List<Location> locations = List.of(new Location("Budapest",0,0), new Location("London",0,0));
        Path file = tempDir.resolve("locations.txt");
        System.out.println(file);
        new LocationService().writeLocations(file, locations);

        String content = Files.readString(file);
        assertEquals("[Budapest,0.0,0.0, London,0.0,0.0]", content);
    }

}
