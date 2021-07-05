package locations;

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

}
