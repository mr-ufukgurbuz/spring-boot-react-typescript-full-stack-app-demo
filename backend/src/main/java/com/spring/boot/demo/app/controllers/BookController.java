package com.spring.boot.demo.app.controllers;

import com.spring.boot.demo.app.models.responses.IResponse;
import com.spring.boot.demo.app.models.requests.BookRequest;
import com.spring.boot.demo.app.models.responses.BookResponse;
import com.spring.boot.demo.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController
{
    @Autowired
    private BookService bookService;

    // RETRIEVE-ALL
    @GetMapping()
    public ResponseEntity<List<IResponse>> retrieveAllBooks()
    {
        List<BookResponse> books = bookService.getAll();

        List<IResponse> bookResponses = new ArrayList<>(books);

        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }

    // RETRIEVE
    @GetMapping("{key}")
    public ResponseEntity<IResponse> retrieveBook(@PathVariable Integer key)
    {
        IResponse bookResponse = bookService.getByKey(key);

        if (bookResponse == null)
        {
            //throw new EntityNotFoundException("bookKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    // CREATE
    @PostMapping()
    public ResponseEntity<IResponse> createBook(@Valid @RequestBody BookRequest bookRequest)
    {
        IResponse insertedBook = bookService.insert(bookRequest);

        if (insertedBook == null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(insertedBook, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping()
    public ResponseEntity<IResponse> updateBook(@Valid @RequestBody BookRequest bookRequest)
    {
        IResponse updatedBook = bookService.update(bookRequest);

        if (updatedBook == null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("{key}")
    public ResponseEntity<IResponse> deleteBook(@PathVariable Integer key)
    {
        IResponse deletedBook = bookService.delete(key);

        if (deletedBook == null)
        {
            //throw new EntityNotFoundException("bookKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }
}
