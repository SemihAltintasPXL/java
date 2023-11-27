package be.pxl.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "be.pxl.hotel")
public class HoteltycoonBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoteltycoonBackendApplication.class, args);
	}

}
