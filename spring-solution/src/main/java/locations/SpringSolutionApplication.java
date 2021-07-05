package locations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSolutionApplication.class, args);
    }

//	@Bean
//	public LocationService locationSerice(){
//		return new LocationService();
//	}

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
