package org.anderi.repository.dynamo;

import lombok.extern.slf4j.Slf4j;
import org.anderi.usecase.dog.port.DogRepository;
import org.anderi.domain.entity.Dog;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
public class DogDynamoDbRepository implements DogRepository {

	private final DynamoDbTable<DogDb> table;
	private final DynamoDbConfig config = new DynamoDbConfig();

	public DogDynamoDbRepository() {
		log.info("Dynamo Repository constructor invoked.");
		this.table = config.getTable(DogDb.TABLE_NAME, DogDb.class);
	}

	@Override public Dog create(Dog dog) {
		log.info("Saving a dog in the table: ",table.tableName());
		this.table.putItem(DogDb.from(dog));
		return dog;
	}

	@Override public Optional<Dog> findById(String id) {
		return Optional.ofNullable(table.getItem(Key.builder()
				.partitionValue(id)
				.build())
			.toDog());
	}

	@Override public List<Dog> findAll() {
		//Not Implemented
		return Collections.emptyList();
	}

	@Override public void delete(Dog dog) {
		table.deleteItem(Key.builder()
			.partitionValue(dog.getId())
			.build());

	}

}
