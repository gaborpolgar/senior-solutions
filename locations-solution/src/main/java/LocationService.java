import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LocationService {

    void writeLocations(Path file, List<Location> locations) {
        try{
                Files.writeString(file, locations.toString());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }

    }
}
