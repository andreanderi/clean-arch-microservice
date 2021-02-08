package org.anderi.repository.dynamo;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ResourceInUseException;

import java.net.URI;

@Slf4j
public class DynamoDbConfig {

    private String dynamoDbEndPointUrl =  "http://127.0.0.1:8000";

    public DynamoDbTable getTable(String tableName, Class tableClass){
	     var table = dynamoDbEnhancedClient()
		    .table(tableName, TableSchema.fromBean(tableClass));

	     createTable(table);
	     return table;

    }
    private void createTable(DynamoDbTable table){
	    try {
		    table.createTable();
	    }catch (ResourceInUseException e){
		    log.warn("The table:{} already exist.", table.tableName());
	    }
    }

	private DynamoDbEnhancedClient dynamoDbEnhancedClient() {
		log.info("Creating enhanced dynamo client.");
		return DynamoDbEnhancedClient.builder()
			.dynamoDbClient(getDynamoDbClient())
			.build();
	}

	private DynamoDbClient getDynamoDbClient() {
		ClientOverrideConfiguration.Builder overrideConfig = ClientOverrideConfiguration.builder();

		AwsSessionCredentials awsCredentials = AwsSessionCredentials.create(
			"accessKey",
			"secretKey",
			"sessionToken");

		return DynamoDbClient.builder()
			.overrideConfiguration(overrideConfig.build())
			.endpointOverride(URI.create(dynamoDbEndPointUrl))
			.region(Region.US_EAST_1)
			.credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
			.build();
	}

}
