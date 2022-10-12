package com.code.GraphQLDemo.repository;

import com.code.GraphQLDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
