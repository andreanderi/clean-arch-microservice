module org.anderi.spring {
	requires org.anderi.config;
	requires org.anderi.usecase;
	requires org.anderi.controller;
	requires spring.web;
	requires spring.beans;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires com.fasterxml.jackson.databind;
	requires jackson.annotations;
	requires lombok;

	exports org.anderi.spring;
	exports org.anderi.spring.config;
	opens org.anderi.spring.config to spring.core;
}
