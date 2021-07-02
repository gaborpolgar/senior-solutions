public class LocationParser {

    private Location location;

    public Location parse(String text) {
        String[] parts = text.split(",");
        return new Location(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
    }

    public boolean isOnEquator(Location location) {
        return location.getLat() == 0;
    }

    public boolean isOnPrimeMeridian(Location location) {
        return location.getLon() == 0;
    }


}
