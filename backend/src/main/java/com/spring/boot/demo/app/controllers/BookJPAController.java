package com.spring.boot.demo.app.controllers;

import com.spring.boot.demo.app.models.requests.BookRequest;
import com.spring.boot.demo.app.models.responses.BookResponse;
import com.spring.boot.demo.app.models.responses.IResponse;
import com.spring.boot.demo.app.services.BookJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/jpa/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookJPAController
{
    @Autowired
    private BookJPAService bookJPAService;

    // RETRIEVE-ALL
    @GetMapping()
    public ResponseEntity<List<IResponse>> retrieveAllBooks()
    {
        List<BookResponse> books = bookJPAService.getAll();

        List<IResponse> bookResponses = new ArrayList<>(books);

        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }

    // RETRIEVE
    @GetMapping("{key}")
    public ResponseEntity<IResponse> retrieveBook(@PathVariable Integer key)
    {
        IResponse bookResponse = bookJPAService.getByKey(key);

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
        IResponse insertedBook = bookJPAService.insert(bookRequest);

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
        IResponse updatedBook = bookJPAService.update(bookRequest);

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
        IResponse deletedBook = bookJPAService.delete(key);

        if (deletedBook == null)
        {
            //throw new EntityNotFoundException("bookKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }
}
