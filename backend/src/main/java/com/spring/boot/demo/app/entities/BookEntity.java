package com.spring.boot.demo.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class BookEntity
{
    @Id
    @GeneratedValue
    private Integer _id;

    @Size(min = 3, message = "Name should have atleast 3 character")
    private String name;

    @Size(min = 10, message = "Name should have atleast 10 characters")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private AuthorEntity authorEntity;

    protected BookEntity()
    {

    }

    public BookEntity(Integer _id, String name, String description)
    {
        super();
        this._id = _id;
        this.name = name;
        this.description = description;
    }

    public Integer getId()
    {
        return _id;
    }

    public void setId(Integer _id)
    {
        this._id = _id;
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

    public AuthorEntity getAuthorEntity()
    {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity)
    {
        this.authorEntity = authorEntity;
    }

    @Override
    public String toString()
    {
        return String.format("Book [_id=%s, name=%s, description=%s]", _id, name, description);
    }
}
