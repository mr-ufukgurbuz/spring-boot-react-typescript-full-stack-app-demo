package com.spring.boot.demo.app.adapters;

import com.spring.boot.demo.app.entities.BookEntity;
import com.spring.boot.demo.app.models.requests.BookRequest;
import com.spring.boot.demo.app.models.responses.BookResponse;

public class BookAdapter
{
    public static BookResponse convertEntityToResponse(BookEntity bookEntity)
    {
        return new BookResponse(bookEntity.getId(), bookEntity.getName(), bookEntity.getDescription());
    }

    public static BookEntity convertRequestToEntity(BookRequest bookRequest)
    {
        return new BookEntity(bookRequest.getKey(), bookRequest.getName(), bookRequest.getDescription());
    }

}
