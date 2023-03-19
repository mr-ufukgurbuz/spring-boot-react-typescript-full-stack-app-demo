package com.spring.boot.demo.app.services;

import com.spring.boot.demo.app.adapters.AuthorAdapter;
import com.spring.boot.demo.app.entities.AuthorEntity;
import com.spring.boot.demo.app.models.requests.AuthorRequest;
import com.spring.boot.demo.app.models.responses.AuthorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class AuthorService
{
    //Initialize Log4j instance
    private static final Logger Log = LogManager.getLogger(AuthorService.class.getName());

    private static List<AuthorEntity> authorEntities = new ArrayList<>();

    private static int authorEntityKey = -1;

    static
    {
        authorEntities.add(new AuthorEntity(++authorEntityKey, "name0", "surname0"));
        authorEntities.add(new AuthorEntity(++authorEntityKey, "name1", "surname1"));
        authorEntities.add(new AuthorEntity(++authorEntityKey, "name2", "surname2"));
    }

    public List<AuthorResponse> getAll()
    {
        List<AuthorResponse> authors = new ArrayList<>();

        for (AuthorEntity authorEntity : authorEntities)
        {
            authors.add(AuthorAdapter.convertEntityToResponse(authorEntity));
        }
        return authors;
    }

    public AuthorResponse getByKey(Integer key)
    {
        for (AuthorEntity authorEntity : authorEntities)
        {
            if (authorEntity.getId() == key)
            {
                return AuthorAdapter.convertEntityToResponse(authorEntity);
            }
        }
        return null;
    }

    public AuthorResponse insert(AuthorRequest authorRequest)
    {
        AuthorEntity authorEntity = AuthorAdapter.convertRequestToEntity(authorRequest);
        authorEntity.setId(++authorEntityKey);
        boolean status = authorEntities.add(authorEntity);

        if (!status)
        {
            return null;
        }
        AuthorResponse author = getByKey(authorEntity.getId());

        return author;
    }

    public AuthorResponse update(AuthorRequest authorRequest)
    {
         AuthorEntity authorEntity = AuthorAdapter.convertRequestToEntity(authorRequest);

        int index = 0;

        while (index < authorEntities.size())
        {
            if (authorEntities.get(index).getId() == authorEntity.getId() && authorEntity.getId() != null)
            {
                authorEntities.set(index, authorEntity);
            }
            index++;
        };
        AuthorResponse author = getByKey(authorRequest.getKey());

        return author;
    }

    public AuthorResponse delete(Integer key)
    {
        Iterator<AuthorEntity> iterator = authorEntities.iterator();

        while (iterator.hasNext())
        {
            AuthorEntity authorEntity = iterator.next();

            if (authorEntity.getId() == key)
            {
                iterator.remove();

                return AuthorAdapter.convertEntityToResponse(authorEntity);
            }
        }
        return null;
    }

}
