package locations;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Location {

    @Override
    public String toString() {
        return name;
    }

    private Long id;
    private String name;
    private double lat;
    private double lon;


}
