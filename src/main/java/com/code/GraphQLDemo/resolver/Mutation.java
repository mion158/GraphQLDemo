package com.code.GraphQLDemo.resolver;

import java.util.Optional;

import com.code.GraphQLDemo.exceptions.BookNotFoundException;
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

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;      
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updatePageCount (Integer pageCount, Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setPageCount(pageCount);
            bookRepository.save(book);

            return book;
        }
        throw new BookNotFoundException("the book was not found", id);
    
    }
    
}
