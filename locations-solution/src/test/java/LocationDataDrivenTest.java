import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationDataDrivenTest {

    Location budapest = new Location("Budapest",0,0);
    Location london = new Location("London",1,0);
    private Location[] values = {budapest, london};
    private boolean[] results = {true, false};
//    private boolean [][] values = {{true,}}

    @RepeatedTest(value = 2, name = "isEquitor {currentRepetition} / {totalRepetitions}")
    void isOnEquitor(RepetitionInfo repetitionInfo){
//     Location location = new Location("Pécs", 0, 0);
        System.out.println("REP: " + repetitionInfo.getCurrentRepetition());
        System.out.println(values[repetitionInfo.getCurrentRepetition()-1]);
        System.out.println(results[repetitionInfo.getCurrentRepetition()-1]);

        assertEquals(results[repetitionInfo.getCurrentRepetition()-1], values[repetitionInfo.getCurrentRepetition()-1].isOnEquator());
    }
}
