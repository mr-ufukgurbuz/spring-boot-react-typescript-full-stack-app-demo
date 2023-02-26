package com.spring.boot.demo.app.adapters;

import com.spring.boot.demo.app.entities.AuthorEntity;
import com.spring.boot.demo.app.models.requests.AuthorRequest;
import com.spring.boot.demo.app.models.responses.AuthorResponse;

public class AuthorAdapter
{
    public static AuthorResponse convertEntityToResponse(AuthorEntity authorEntity)
    {
        return new AuthorResponse(authorEntity.getId(), authorEntity.getName(), authorEntity.getSurname());
    }

    public static AuthorEntity convertRequestToEntity(AuthorRequest authorRequest)
    {
        return new AuthorEntity(authorRequest.getKey(), authorRequest.getName(), authorRequest.getSurname());
    }

}
