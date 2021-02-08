package org.anderi.config;

import org.anderi.converter.UnitConverter;
import org.anderi.repository.memory.InMemoryDogDbRepository;
import org.anderi.usecase.dog.CreateDog;
import org.anderi.usecase.dog.port.Converter;
import org.anderi.usecase.dog.port.DogRepository;

public class ManualConfig {
	private final DogRepository repository = new InMemoryDogDbRepository();
	private final Converter unitConverter = new UnitConverter();

	public CreateDog createDog() {
		return new CreateDog(repository, unitConverter);
	}

}
