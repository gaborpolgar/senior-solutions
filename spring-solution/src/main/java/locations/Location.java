package locations;


import lombok.Data;

@Data
public class Location {

    private Long id;
    private String name;
    private double lat;
    private double lon;


}
