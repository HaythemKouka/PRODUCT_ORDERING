package com.example.ProdOrder;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLScalarConfig {

    @Bean
      GraphQLScalarType dateTime() {
        return ExtendedScalars.DateTime;
    }
}
