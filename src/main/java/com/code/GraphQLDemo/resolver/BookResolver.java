package com.code.GraphQLDemo.resolver;

import com.code.GraphQLDemo.model.*;
import com.code.GraphQLDemo.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;


public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
    }
    
}
