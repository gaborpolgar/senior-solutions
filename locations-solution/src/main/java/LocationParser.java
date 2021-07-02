public class LocationParser {

    public Location parse(String text) {
        String[] parts = text.split(",");
        return new Location(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
    }
}
