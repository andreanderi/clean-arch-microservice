package org.anderi.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.anderi.config.SpringConfig;
import org.anderi.controller.DogController;
import org.anderi.usecase.dog.CreateDog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	private final SpringConfig config = new SpringConfig();

	@Bean
	public ObjectMapper objectMapper() {
		var objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	@Bean
	public CreateDog createDog() {
		return config.createDog();
	}

	@Bean
	public DogController dogController() {
		return new DogController(createDog());
	}

	//@Bean
	//public UserController userController() {
	//	return new UserController(createUser(), findUser(), loginUser());
	//}
}
