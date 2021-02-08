package org.anderi.console;

import org.anderi.config.ManualConfig;
import org.anderi.domain.entity.Dog;

import java.util.UUID;

public class Main {
	public static void main(String[] args) {
		// Setup
		var config = new ManualConfig();
		var createDog = config.createDog();

		var dog =  Dog.builder()
			.id(UUID.randomUUID().toString())
			.breed("frenchie")
			.name("lili")
			.heightInCentimeters(30)
			.weightInKilograms(10)
			.lifeSpanInYears(14)
			.build();

		// Create a user
		var actualCreateDog = createDog.create(dog);
		System.out.println("User created with id " + actualCreateDog.getId());

	}
}
