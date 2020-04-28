package com.example.springmongodb.controller;

import com.example.springmongodb.model.Book;
import com.example.springmongodb.repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Book Operation with respect to MongoDB", description = "Testing")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book/addBook")
    @ApiOperation(value = "Save book data to MongoDB")
    public String saveBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return " Book Saved id = "+book.getId();
    }

    @GetMapping("/book/getAllBook")
    @ApiOperation(value = "Return all the Book data from MongoDB")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/book/getBookById/{id}")
    @ApiOperation(value = "Return Selected Book data from MongoDB")
    public Optional<Book> getBook(@PathVariable int id)
    {
        return bookRepository.findById(id);
    }

    @DeleteMapping ("/book/deleteBookById/{id}")
    @ApiOperation(value = "Delete the Specific Book data from MongoDB")
    @ApiResponses(
            value ={
            @ApiResponse(code = 100, message ="100 is message"),
            @ApiResponse(code = 200, message = "Book related operation is sucessful")
            }
            )
    public String deleteBook(@PathVariable int id)
    {
         bookRepository.deleteById(id);
         return "Book deleted by ID = "+id;
    }



}
