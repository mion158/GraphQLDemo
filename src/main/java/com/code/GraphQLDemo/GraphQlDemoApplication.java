package com.code.GraphQLDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.code.GraphQLDemo.repository.AuthorRepository;
import com.code.GraphQLDemo.repository.BookRepository;
import com.code.GraphQLDemo.resolver.BookResolver;
import com.code.GraphQLDemo.resolver.Mutation;
import com.code.GraphQLDemo.resolver.Query;

@SpringBootApplication
public class GraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlDemoApplication.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}


}
