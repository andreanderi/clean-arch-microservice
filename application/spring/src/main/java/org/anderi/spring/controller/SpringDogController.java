package org.anderi.spring.controller;

import lombok.RequiredArgsConstructor;
import org.anderi.controller.DogController;
import org.anderi.controller.model.DogRequest;
import org.anderi.controller.model.DogResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpringDogController {

	private final DogController controller;

	@PostMapping(value = "/dogs")
	public DogResponse createDog(@RequestBody final DogRequest request) {

		return controller.createDog(request);
	}

}
