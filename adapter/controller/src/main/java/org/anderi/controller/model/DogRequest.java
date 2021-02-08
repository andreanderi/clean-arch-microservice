package org.anderi.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.anderi.domain.entity.Dog;

@Getter
@Setter
public class DogRequest {
	private String id;
	private String breed;
	private String name;
	private long heightInCentimeters;
	private long weightInKilograms;
	private long lifeSpanInYears;

	public Dog toDog() {
		return Dog.builder()
			.breed(breed)
			.name(name)
			.heightInCentimeters(heightInCentimeters)
			.weightInKilograms(heightInCentimeters)
			.lifeSpanInYears(lifeSpanInYears)
			.build();
	}

}
