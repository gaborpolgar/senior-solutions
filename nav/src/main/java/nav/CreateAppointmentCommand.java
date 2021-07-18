package nav;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentCommand {

    private String taxNumber;
    private LocalDateTime start;
    private LocalDateTime end;
    private String typeCode;


}
