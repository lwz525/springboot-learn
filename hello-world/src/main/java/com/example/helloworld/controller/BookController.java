package com.example.helloworld.controller;

import com.example.helloworld.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @RequestMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.ok(books);
    }

    public List<Book> getBooks() {
        return books;
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<List<Book>> deleteBookById(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity<Object> getBookByName(@RequestParam("name") String name) {
        List<Book> books = this.books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }
}
