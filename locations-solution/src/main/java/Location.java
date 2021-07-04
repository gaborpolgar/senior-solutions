public class Location {

    private String name;
    private double lat;
    private double lon;

    public Location(double lat) {
        this.lat = lat;
    }

    public Location(String name, double lat, double lon) {
        this.name = name;
        if (lat > 90 || lat < -90){
            throw new IllegalArgumentException("latitude: " + lat);
        }
        this.lat = lat;
        if (lon > 180 || lon < -180){
            throw new IllegalArgumentException("longitude: " + lon);
        }
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public double distanceFrom(Location location, Location anotherLocation){
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(anotherLocation.getLat() - location.getLat());
        double lonDistance = Math.toRadians(anotherLocation.getLon() - location.getLon());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(location.getLat())) * Math.cos(Math.toRadians(anotherLocation.getLat()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

    public boolean isOnEquator() {
        return this.getLat() == 0;
    }

    public boolean isOnPrimeMeridian() {
        return this.getLon() == 0;
    }

}
