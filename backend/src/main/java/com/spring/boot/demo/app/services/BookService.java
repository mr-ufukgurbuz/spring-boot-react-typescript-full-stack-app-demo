package com.spring.boot.demo.app.services;

import com.spring.boot.demo.app.adapters.BookAdapter;
import com.spring.boot.demo.app.entities.BookEntity;
import com.spring.boot.demo.app.models.requests.BookRequest;
import com.spring.boot.demo.app.models.responses.BookResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class BookService
{
    //Initialize Log4j instance
    private static final Logger Log = Logger.getLogger(BookService.class.getName());

    private static List<BookEntity> bookEntities = new ArrayList<>();

    private static int bookEntityKey = -1;

    static
    {
        bookEntities.add(new BookEntity(++bookEntityKey, "bookName0", "description0"));
        bookEntities.add(new BookEntity(++bookEntityKey, "bookName1", "description1"));
        bookEntities.add(new BookEntity(++bookEntityKey, "bookName2", "description2"));
    }

    public List<BookResponse> getAll()
    {
        List<BookResponse> books = new ArrayList<>();

        for (BookEntity bookEntity : bookEntities)
        {
            books.add(BookAdapter.convertEntityToResponse(bookEntity));
        }
        return books;
    }

    public BookResponse getByKey(Integer key)
    {
        for (BookEntity bookEntity : bookEntities)
        {
            if (bookEntity.getId() == key)
            {
                return BookAdapter.convertEntityToResponse(bookEntity);
            }
        }
        return null;
    }

    public BookResponse insert(BookRequest bookRequest)
    {
        BookEntity bookEntity = BookAdapter.convertRequestToEntity(bookRequest);
        bookEntity.setId(++bookEntityKey);
        boolean status = bookEntities.add(bookEntity);

        if (!status)
        {
            return null;
        }
        BookResponse book = getByKey(bookEntity.getId());

        return book;
    }

    public BookResponse update(BookRequest bookRequest)
    {
        BookEntity bookEntity = BookAdapter.convertRequestToEntity(bookRequest);

        int index = 0;

        while (index < bookEntities.size())
        {
            if (bookEntities.get(index).getId() == bookEntity.getId() && bookEntity.getId() != null)
            {
                bookEntities.set(index, bookEntity);
            }
            index++;
        };
        BookResponse book = getByKey(bookRequest.getKey());

        return book;
    }

    public BookResponse delete(Integer key)
    {
        Iterator<BookEntity> iterator = bookEntities.iterator();

        while (iterator.hasNext())
        {
            BookEntity bookEntity = iterator.next();

            if (bookEntity.getId() == key)
            {
                iterator.remove();

                return BookAdapter.convertEntityToResponse(bookEntity);
            }
        }
        return null;
    }

}

