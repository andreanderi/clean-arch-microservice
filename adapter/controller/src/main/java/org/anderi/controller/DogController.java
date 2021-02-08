package org.anderi.controller;

import lombok.AllArgsConstructor;
import org.anderi.controller.model.DogRequest;
import org.anderi.controller.model.DogResponse;
import org.anderi.usecase.dog.CreateDog;

@AllArgsConstructor
public class DogController {

	private final CreateDog createDog;

	public DogResponse createDog(final DogRequest dogRequest) {

		var dog = dogRequest.toDog();

		return DogResponse.from(createDog.create(dog));
	}

}
