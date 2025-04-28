package com.hospital.hospital_automation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.hospital.hospital_automation.entity")
public class HospitalAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAutomationApplication.class, args);
	}

}
