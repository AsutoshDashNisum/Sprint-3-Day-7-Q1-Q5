package com.example.calculator.controller;

import com.example.calculator.model.BookQ5;
import com.example.calculator.repository.BookRepositoryQ5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookControllerQ5 {

    @Autowired
    private BookRepositoryQ5 bookRepository;

    // GET all books
    @GetMapping
    public List<BookQ5> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookQ5> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST a new book
    @PostMapping
    public BookQ5 createBook(@RequestBody BookQ5 book) {
        return bookRepository.save(book);
    }

    // PUT (update) a book
    @PutMapping("/{id}")
    public ResponseEntity<BookQ5> updateBook(@PathVariable Long id, @RequestBody BookQ5 bookDetails) {
        Optional<BookQ5> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookQ5 book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublishedYear(bookDetails.getPublishedYear());
            return ResponseEntity.ok(bookRepository.save(book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
