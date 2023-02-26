package com.spring.boot.demo.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class AuthorEntity
{
    @Id
    @GeneratedValue
    private Integer _id;

    @Size(min = 3, message = "Name should have atleast 3 characters")
    private String name;

    @Size(min = 3, message = "Name should have atleast 3 characters")
    private String surname;

    @OneToMany(mappedBy = "authorEntity")
    private List<BookEntity> bookEntities;

    protected AuthorEntity()
    {

    }

    public AuthorEntity(Integer _id, String name, String surname)
    {
        super();
        this._id = _id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public List<BookEntity> getBookEntities()
    {
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities)
    {
        this.bookEntities = bookEntities;
    }

    @Override
    public String toString()
    {
        return String.format("Author [_id=%s, name=%s, surname=%s]", _id, name, surname);
    }

}
