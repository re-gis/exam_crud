package com.jusish.exam.controllers;

import com.jusish.exam.dtos.CreateBookDto;
import com.jusish.exam.models.Book;
import com.jusish.exam.serviceImpl.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookServiceImpl bookService;
    BookController(BookServiceImpl bookService){
        this.bookService = bookService;
    }
    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookDto dto)throws Exception{
        return ResponseEntity.ok(bookService.createBook(dto));
    }
}
