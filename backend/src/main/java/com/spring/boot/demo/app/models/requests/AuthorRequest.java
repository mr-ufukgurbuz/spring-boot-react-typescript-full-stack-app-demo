package com.spring.boot.demo.app.models.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "All details about the author.")
public class AuthorRequest implements IRequest
{
    private Integer key;

    @ApiModelProperty(notes = "Name should have atleast 3 characters")
    private String name;

    @ApiModelProperty(notes = "Surname should have atleast 3 characters")
    private String surname;

    private List<BookRequest> books;

    protected AuthorRequest()
    {

    }

    public AuthorRequest(String name, String surname)
    {
        super();
        this.name = name;
        this.surname = surname;
    }

    public AuthorRequest(Integer key, String name, String surname)
    {
        super();
        this.key = key;
        this.name = name;
        this.surname = surname;
    }

    public Integer getKey()
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public List<BookRequest> getBooks()
    {
        return books;
    }

    public void setBooks(List<BookRequest> books)
    {
        this.books = books;
    }

    @Override
    public String toString()
    {
        return String.format("Author [key=%s, name=%s, surname=%s]", key, name, surname);
    }

}
