package com.example.calculator.repository;

import com.example.calculator.model.BookQ5;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
