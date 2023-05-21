package com.example.work_hours_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WorkHoursTrackerApplication {


	public static void main(String[] args) {
		SpringApplication.run(WorkHoursTrackerApplication.class, args);
	}

}
