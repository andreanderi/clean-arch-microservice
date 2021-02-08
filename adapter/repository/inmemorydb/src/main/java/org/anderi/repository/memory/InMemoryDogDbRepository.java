package org.anderi.repository.memory;

import org.anderi.domain.entity.Dog;
import org.anderi.usecase.dog.port.DogRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryDogDbRepository implements DogRepository {

	private final Map<String, Dog> inMemoryDb = new HashMap<>();

	@Override
	public Dog create(final Dog dog) {
		inMemoryDb.put(dog.getId(), dog);
		return dog;
	}

	@Override public Optional<Dog> findById(String id) {
		return Optional.empty();
	}

	@Override public List<Dog> findAll() {
		return null;
	}

	@Override public void delete(Dog dog) {

	}

}
