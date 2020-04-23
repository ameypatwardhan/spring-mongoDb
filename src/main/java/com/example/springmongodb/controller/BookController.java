package com.example.springmongodb.controller;

import com.example.springmongodb.model.Book;
import com.example.springmongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return " Book Saved id"+book.getId();
    }

    @GetMapping("/getAllBook")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public Optional<Book> getBook(@PathVariable int id)
    {
        return bookRepository.findById(id);
    }

    @DeleteMapping ("/deleteBookById/{id}")
    public String deleteBook(@PathVariable int id)
    {
         bookRepository.deleteById(id);
         return "Book deleted by ID "+id;
    }



}
