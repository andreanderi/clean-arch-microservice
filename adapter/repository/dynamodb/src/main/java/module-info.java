module org.anderi.repository.dynamo{
	exports org.anderi.repository.dynamo;

	requires org.anderi.domain;
	requires org.anderi.usecase;
	requires lombok;
	requires org.slf4j;

	requires software.amazon.awssdk.services.dynamodb;
	requires software.amazon.awssdk.core;
	requires software.amazon.awssdk.enhanced.dynamodb;
	requires software.amazon.awssdk.auth;
	requires software.amazon.awssdk.regions;
}
