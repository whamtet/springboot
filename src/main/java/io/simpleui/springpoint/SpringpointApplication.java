package io.simpleui.springpoint;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class SpringpointApplication {

	@RequestMapping("/**")
	String home(HttpServletRequest request) {
		return request.getRequestURI();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringpointApplication.class, args);
	}

}
