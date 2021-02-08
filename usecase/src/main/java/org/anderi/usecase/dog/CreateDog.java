package org.anderi.usecase.dog;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.anderi.domain.entity.Dog;
import org.anderi.usecase.dog.port.Converter;
import org.anderi.usecase.dog.port.DogRepository;

@AllArgsConstructor
@Slf4j
public final class CreateDog {

	private final DogRepository repository;
	private final Converter unitConverter;

	public Dog create(final Dog dog) {

		var dogToSave = Dog.builder()
			.breed(dog.getBreed())
			.lifeSpanInYears(dog.getLifeSpanInYears())
			.weightInKilograms(dog.getWeightInKilograms())
			.heightInCentimeters(dog.getHeightInCentimeters())
			.weightInPounds(unitConverter.kilogramToPound(dog.getWeightInKilograms()))
			.heightInInches(unitConverter.centimeterToInch(dog.getHeightInCentimeters()))
			.name(dog.getName())
			.build();

		var userMaybeNull = repository.create(dogToSave);
		log.info("Dog saved: " + dogToSave.toString());

		return userMaybeNull;
	}
}
