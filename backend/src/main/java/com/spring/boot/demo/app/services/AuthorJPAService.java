package com.spring.boot.demo.app.services;

import com.spring.boot.demo.app.adapters.AuthorAdapter;
import com.spring.boot.demo.app.entities.AuthorEntity;
import com.spring.boot.demo.app.models.requests.AuthorRequest;
import com.spring.boot.demo.app.models.responses.AuthorResponse;
import com.spring.boot.demo.app.repositories.AuthorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorJPAService
{
    //Initialize Log4j instance
    private static final Logger Log = LogManager.getLogger(AuthorJPAService.class.getName());

    @Autowired
    private AuthorRepository authorRepository;


    public List<AuthorResponse> getAll()
    {
        List<AuthorEntity> authorEntities = authorRepository.findAll();

        List<AuthorResponse> authors = new ArrayList<>();

        for (AuthorEntity authorEntity : authorEntities)
        {
            authors.add(AuthorAdapter.convertEntityToResponse(authorEntity));
        }

        return authors;
    }

    public AuthorResponse getByKey(Integer key)
    {
        Optional<AuthorEntity> authorEntity = authorRepository.findById(key);

        if (authorEntity.isEmpty())
        {
            return null;
        }

        return AuthorAdapter.convertEntityToResponse(authorEntity.get());
    }

    public AuthorResponse insert(AuthorRequest authorRequest)
    {
        AuthorResponse savedAuthorResponse = AuthorAdapter.convertEntityToResponse(authorRepository.save(AuthorAdapter.convertRequestToEntity(authorRequest)));

        return savedAuthorResponse;
    }

    public AuthorResponse update(AuthorRequest authorRequest)
    {
        AuthorResponse updatedAuthorResponse = AuthorAdapter.convertEntityToResponse(authorRepository.save(AuthorAdapter.convertRequestToEntity(authorRequest)));

        return updatedAuthorResponse;
    }

    public AuthorResponse delete(Integer key)
    {
        Optional<AuthorEntity> authorEntity = authorRepository.findById(key);

        if (authorEntity.isEmpty())
        {
            return null;
        }

        authorRepository.deleteById(key);

        AuthorResponse deletedAuthorResponse = AuthorAdapter.convertEntityToResponse(authorEntity.get());

        return deletedAuthorResponse;
    }
}
