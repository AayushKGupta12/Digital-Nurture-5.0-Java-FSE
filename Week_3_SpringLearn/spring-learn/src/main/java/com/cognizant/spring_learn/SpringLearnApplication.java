package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {

		displayCountry();

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