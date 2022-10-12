package com.code.GraphQLDemo.repository;

import com.code.GraphQLDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
