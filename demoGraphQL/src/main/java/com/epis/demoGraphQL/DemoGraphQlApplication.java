package com.epis.demoGraphQL;

import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

}
