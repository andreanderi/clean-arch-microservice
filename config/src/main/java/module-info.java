module org.anderi.config {
	exports org.anderi.config;
	requires org.anderi.usecase;
	requires org.anderi.domain;
	requires org.anderi.repository.dynamo;
	requires org.anderi.repository.memory;
	requires org.anderi.converter;

}
