package com.example.universitysite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class UniversitySiteApplication {

	public static void main(String args[])

	{

		SpringApplication.run(UniversitySiteApplication.class, args);
	}




}
