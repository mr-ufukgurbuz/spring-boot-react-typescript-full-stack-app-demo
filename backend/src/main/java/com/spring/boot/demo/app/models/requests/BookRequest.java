package com.spring.boot.demo.app.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the book.")
public class BookRequest implements IRequest
{
    private Integer key;

    @ApiModelProperty(notes = "Surname should have atleast 1 character")
    private String name;

    @ApiModelProperty(notes = "Surname should have atleast 10 characters")
    private String description;

    @JsonIgnore
    private AuthorRequest author;

    protected BookRequest()
    {

    }

    public BookRequest(String name, String description)
    {
        super();
        this.name = name;
        this.description = description;
    }

    public BookRequest(Integer key, String name, String description)
    {
        super();
        this.key = key;
        this.name = name;
        this.description = description;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public AuthorRequest getAuthor()
    {
        return author;
    }

    public void setAuthor(AuthorRequest author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return String.format("Book [key=%s, name=%s, description=%s]", key, name, description);
    }

}
