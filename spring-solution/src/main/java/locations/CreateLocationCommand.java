package locations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationCommand {

    private double lat;
    private double lon;

    public CreateLocationCommand(String name) {
        this.name = name;
    }

    @Schema(description = "name of the location", example = "Budapest")
//    @NotBlank(message = "Name can not be blank")
//    @Name(maxLength = 20)
    @Name
    private String name;
}
