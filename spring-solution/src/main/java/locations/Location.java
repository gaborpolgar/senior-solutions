package locations;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    public Location(String name) {
        this.name = name;
    }

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;
    private double lat;
    private double lon;


    @Override
    public String toString() {
        return name;
    }
}
