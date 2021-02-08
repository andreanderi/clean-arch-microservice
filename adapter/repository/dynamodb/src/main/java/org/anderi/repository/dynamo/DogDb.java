package org.anderi.repository.dynamo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.anderi.domain.entity.Dog;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbIgnore;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.io.Serializable;
import java.util.UUID;

@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DogDb implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String TABLE_NAME = "clean-arch-dog";

	@Builder.Default
	private String id = UUID.randomUUID().toString();
	private String breed;
	private String name;
	private long heightInCentimeters;
	private long weightInKilograms;
	private long heightInInches;
	private long weightInPounds;
	private long lifeSpanInYears;

	@DynamoDbPartitionKey
	public String getId() {
		return id;
	}

	@DynamoDbIgnore
	public Dog toDog() {
		return Dog.builder()
			.id(id)
			.breed(breed)
			.name(name)
			.heightInCentimeters(heightInCentimeters)
			.weightInKilograms(weightInKilograms)
			.lifeSpanInYears(lifeSpanInYears)
			.build();
	}

	@DynamoDbIgnore
	public static DogDb from(final Dog dog) {

		return DogDb.builder()
			.breed(dog.getBreed())
			.name(dog.getName())
			.heightInCentimeters(dog.getHeightInCentimeters())
			.weightInKilograms(dog.getWeightInKilograms())
			.heightInInches(dog.getHeightInInches())
			.weightInPounds(dog.getWeightInPounds())
			.lifeSpanInYears(dog.getLifeSpanInYears())
			.build();
	}
}
