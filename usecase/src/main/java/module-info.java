module org.anderi.usecase {
	exports org.anderi.usecase.dog;
	exports org.anderi.usecase.dog.port;

	requires org.anderi.domain;
	requires org.apache.commons.lang3;
	requires org.slf4j;

	requires lombok;
}
