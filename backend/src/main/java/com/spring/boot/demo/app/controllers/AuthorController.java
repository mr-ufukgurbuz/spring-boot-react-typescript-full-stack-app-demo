package com.spring.boot.demo.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.spring.boot.demo.app.models.responses.IResponse;
import com.spring.boot.demo.app.models.requests.AuthorRequest;
import com.spring.boot.demo.app.models.responses.AuthorResponse;
import com.spring.boot.demo.app.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;

    // RETRIEVE-ALL
    @GetMapping()
    public ResponseEntity<List<IResponse>> retrieveAllAuthors()
    {
        List<AuthorResponse> authors = authorService.getAll();

        List<IResponse> authorResponses = new ArrayList<>(authors);

        return new ResponseEntity<>(authorResponses, HttpStatus.OK);
    }

    // RETRIEVE
    @GetMapping("{key}")
    public ResponseEntity<IResponse> retrieveAuthor(@PathVariable Integer key)
    {
        IResponse authorResponse = authorService.getByKey(key);

        if (authorResponse == null)
        {
            //throw new EntityNotFoundException("authorKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    // CREATE
    @PostMapping()
    public ResponseEntity<IResponse> createAuthor(@Valid @RequestBody AuthorRequest authorRequest)
    {
        IResponse insertedAuthor = authorService.insert(authorRequest);

        if (insertedAuthor == null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(insertedAuthor, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping()
    public ResponseEntity<IResponse> updateAuthor(@Valid @RequestBody AuthorRequest authorRequest)
    {
        IResponse updatedAuthor = authorService.update(authorRequest);

        if (updatedAuthor == null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("{key}")
    public ResponseEntity<IResponse> deleteAuthor(@PathVariable Integer key)
    {
        IResponse deletedAuthor = authorService.delete(key);

        if (deletedAuthor == null)
        {
            //throw new EntityNotFoundException("authorKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedAuthor, HttpStatus.OK);
    }
}