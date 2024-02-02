package com.example.RestApiDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApiDemo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
