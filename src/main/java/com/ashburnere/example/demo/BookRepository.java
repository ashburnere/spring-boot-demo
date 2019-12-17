package com.ashburnere.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Define a repository for book, making good use of Spring Data here:
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
