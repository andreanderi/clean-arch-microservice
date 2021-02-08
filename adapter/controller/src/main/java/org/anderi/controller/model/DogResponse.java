package org.anderi.controller.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.anderi.domain.entity.Dog;

@Getter
@Setter
@Builder
public class DogResponse {
	private String id;
	private String breed;
	private String name;
	private long heightInCentimeters;
	private long weightInKilograms;
	private long lifeSpanInYears;
	private long heightInInches;
	private long weightInPounds;

	public static DogResponse from(Dog dog) {
		return  DogResponse.builder()
			.breed(dog.getBreed())
			.name(dog.getName())
			.heightInCentimeters(dog.getHeightInCentimeters())
			.weightInKilograms(dog.getWeightInKilograms())
			.lifeSpanInYears(dog.getLifeSpanInYears())
			.heightInInches(dog.getHeightInInches())
			.weightInPounds(dog.getWeightInPounds())
			.build();
	}
}
