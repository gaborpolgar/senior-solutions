//package locations;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class LocationsControllerTest {
//
//    @Mock
//    LocationService locationService;
//
//    @InjectMocks
//    LocationsController locationsController;
//
//    ModelMapper modelMapper;
//
//    @Test
//    void getLocations() {
//        List<Location> locations = new ArrayList<>(List.of(new Location(10L, "Budapest", 5, 5), new Location(100L, "London", 50, 50)));
//        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
//        modelMapper.map(locations, targetListType);
//        when(locationService.getLocations()).thenReturn(modelMapper.map(locations, targetListType));
//
//        String locationsName  = locationsController.getLocations();
//
//        assertThat(locationsName).isEqualTo("Budapest, London, ");
//    }
//}