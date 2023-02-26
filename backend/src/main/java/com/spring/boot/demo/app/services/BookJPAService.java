package com.spring.boot.demo.app.services;

import com.spring.boot.demo.app.adapters.BookAdapter;
import com.spring.boot.demo.app.entities.BookEntity;
import com.spring.boot.demo.app.models.requests.BookRequest;
import com.spring.boot.demo.app.models.responses.BookResponse;
import com.spring.boot.demo.app.repositories.BookRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class BookJPAService
{
    //Initialize Log4j instance
    private static final Logger Log = Logger.getLogger(BookJPAService.class.getName());

    @Autowired
    private BookRepository bookRepository;


    public List<BookResponse> getAll()
    {
        List<BookEntity> bookEntities = bookRepository.findAll();

        List<BookResponse> books = new ArrayList<>();

        for (BookEntity bookEntity : bookEntities)
        {
            books.add(BookAdapter.convertEntityToResponse(bookEntity));
        }
        return books;
    }

    public BookResponse getByKey(Integer key)
    {
        Optional<BookEntity> bookEntity = bookRepository.findById(key);

        if (bookEntity.isEmpty())
        {
            return null;
        }

        return BookAdapter.convertEntityToResponse(bookEntity.get());
    }

    public BookResponse insert(BookRequest bookRequest)
    {
        BookResponse savedBookResponse = BookAdapter.convertEntityToResponse(bookRepository.save(BookAdapter.convertRequestToEntity(bookRequest)));

        return savedBookResponse;
    }

    public BookResponse update(BookRequest bookRequest)
    {
        BookResponse updatedBookResponse = BookAdapter.convertEntityToResponse(bookRepository.save(BookAdapter.convertRequestToEntity(bookRequest)));

        return updatedBookResponse;
    }

    public BookResponse delete(Integer key)
    {
        Optional<BookEntity> bookEntity = bookRepository.findById(key);

        if (bookEntity.isEmpty())
        {
            return null;
        }

        bookRepository.deleteById(key);

        BookResponse deletedBookResponse = BookAdapter.convertEntityToResponse(bookEntity.get());

        return deletedBookResponse;
    }
}

