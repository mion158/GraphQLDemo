package com.code.GraphQLDemo.resolver;

import com.code.GraphQLDemo.model.*;
import com.code.GraphQLDemo.repository.*;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;


public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    
}
