package com.spring.boot.demo.app.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Document(collection = "city")
public class CityEntity
{
    @Id
    @GeneratedValue
    private String _id;

    @Min(value = 3, message = "Code should be bigger than '0'")
    private Integer code;

    @Size(min = 3, message = "Name should have atleast 3 characters")
    private String name;

    @Min(value = -180, message = "Latitude can't be lower than '-180'")
    @Max(value = 180, message = "Latitude can't be bigger than '180'")
    private Double latitude;

    @Min(value = 0, message = "Longitude can't be lower than '0'")
    @Max(value = 360, message = "Longitude can't be bigger than '360'")
    private Double longitude;

    @Size(min = 3, message = "_Class should have atleast 3 characters")
    private String _class;

    protected CityEntity()
    {

    }

    public CityEntity(String _id, Integer code, String name, Double latitude, Double longitude, String _class)
    {
        super();
        this._id = _id;
        this.code = code;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this._class = _class;
    }

    public String getId()
    {
        return _id;
    }

    public void setId(String key)
    {
        this._id = key;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public String get_class()
    {
        return _class;
    }

    public void set_class(String _class)
    {
        this._class = _class;
    }

    @Override
    public String toString()
    {
        return String.format("City [_id=%s, code=%s, name=%s, latitude=%s, longitude=%s, _class=%s]", _id, code, name, latitude, longitude, _class);
    }

}

