package nguyen.thi.thien;

import nguyen.thi.thien.core.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class ThienApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThienApplication.class, args);
	}

}
