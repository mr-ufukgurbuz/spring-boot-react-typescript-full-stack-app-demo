package com.spring.boot.demo.app.controllers;

import com.spring.boot.demo.app.models.requests.AuthorRequest;
import com.spring.boot.demo.app.models.responses.AuthorResponse;
import com.spring.boot.demo.app.models.responses.IResponse;
import com.spring.boot.demo.app.services.AuthorJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/jpa/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorJPAController
{
    @Autowired
    private AuthorJPAService authorJPAService;

    // RETRIEVE-ALL
    @GetMapping()
    public ResponseEntity<List<IResponse>> retrieveAllAuthors()
    {
        List<AuthorResponse> authors = authorJPAService.getAll();

        List<IResponse> authorResponses = new ArrayList<>(authors);

        return new ResponseEntity<>(authorResponses, HttpStatus.OK);
    }

    // RETRIEVE
    @GetMapping("{key}")
    public ResponseEntity<IResponse> retrieveAuthor(@PathVariable Integer key)
    {
        IResponse authorResponse = authorJPAService.getByKey(key);

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
        IResponse insertedAuthor = authorJPAService.insert(authorRequest);

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
        IResponse updatedAuthor = authorJPAService.update(authorRequest);

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
        IResponse deletedAuthor = authorJPAService.delete(key);

        if (deletedAuthor == null)
        {
            //throw new EntityNotFoundException("authorKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedAuthor, HttpStatus.OK);
    }
}

