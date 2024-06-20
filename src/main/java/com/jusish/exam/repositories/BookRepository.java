package com.jusish.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jusish.exam.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
