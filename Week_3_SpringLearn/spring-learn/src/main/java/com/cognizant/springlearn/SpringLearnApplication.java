package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {

		// Uncomment this only for Hands-on 4
		// displayCountry();

		SpringApplication.run(SpringLearnApplication.class, args);
	}

	public static void displayCountry() {

		try {
			System.out.println("Loading XML...");

			ApplicationContext context =
					new ClassPathXmlApplicationContext("country.xml");

			System.out.println("XML Loaded");

			Country country = context.getBean("country", Country.class);

			System.out.println(country);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}