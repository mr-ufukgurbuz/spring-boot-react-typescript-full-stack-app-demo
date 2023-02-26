package com.spring.boot.demo.app.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the book.")
public class BookResponse implements IResponse
{
    private Integer key;

    @ApiModelProperty(notes = "Surname should have atleast 1 character")
    private String name;

    @ApiModelProperty(notes = "Surname should have atleast 10 characters")
    private String description;

    @JsonIgnore
    private AuthorResponse author;

    protected BookResponse()
    {

    }

    public BookResponse(Integer key, String name, String description)
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

    public void setKey(Integer key)
    {
        this.key = key;
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

    public AuthorResponse getAuthor()
    {
        return author;
    }

    public void setAuthor(AuthorResponse author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return String.format("Book [key=%s, name=%s, description=%s]", key, name, description);
    }

}
