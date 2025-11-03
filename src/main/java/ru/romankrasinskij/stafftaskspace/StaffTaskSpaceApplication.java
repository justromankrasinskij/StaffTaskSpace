package ru.romankrasinskij.stafftaskspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.romankrasinskij.stafftaskspace.services.RegistrationService;

@SpringBootApplication
public class StaffTaskSpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffTaskSpaceApplication.class, args);
	}
}
