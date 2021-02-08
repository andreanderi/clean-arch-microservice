package org.anderi.usecase.dog.port;

import org.anderi.domain.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface DogRepository {

	Dog create(Dog dog);

	Optional<Dog> findById(String id);

	List<Dog> findAll();

	void delete(Dog dog);

}
