package org.anderi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Dog {

	private String id;
	private String breed;
	private String name;
	private long heightInCentimeters;
	private long weightInKilograms;
	private long lifeSpanInYears;
	private long heightInInches;
	private long weightInPounds;

	@Override
	public String toString() {
		return "Dog{" +
			"id='" + id + '\'' +
			", breed='" + breed + '\'' +
			", name='" + name + '\'' +
			", heightInCentimeters='" + heightInCentimeters + '\'' +
			", weightInKilograms='" + weightInKilograms + '\'' +
			", heightInInches='" + heightInInches + '\'' +
			", weightInPounds='" + weightInPounds + '\'' +
			", lifeSpanInYears='" + lifeSpanInYears + '\'' +
			'}';
	}
}
