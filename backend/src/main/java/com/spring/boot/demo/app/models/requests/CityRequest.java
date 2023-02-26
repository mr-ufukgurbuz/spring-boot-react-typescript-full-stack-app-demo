package com.spring.boot.demo.app.models.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the City.")
public class CityRequest implements IRequest
{
    private String key;

    @ApiModelProperty(notes = "Code should be bigger than '0'")
    private Integer code;

    @ApiModelProperty(notes = "Name should have atleast 3 characters")
    private String name;

    @ApiModelProperty(notes = "Latitude should be between '-180' and '180' range")
    private Double latitude;

    @ApiModelProperty(notes = "Longitude should be between '0' and '360' range")
    private Double longitude;

    @ApiModelProperty(notes = "_Class should have atleast 3 characters")
    private String _class;

    protected CityRequest()
    {

    }

    public CityRequest(Integer code, String name, Double latitude, Double longitude, String _class)
    {
        super();
        this.code = code;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this._class = _class;
    }

    public CityRequest(String key, Integer code, String name, Double latitude, Double longitude, String _class)
    {
        super();
        this.key = key;
        this.code = code;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this._class = _class;
    }

    public String getKey()
    {
        return key;
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
        return String.format("City [key=%s, code=%s, name=%s, latitude=%s, longitude=%s, _class=%s]", key, code, name, latitude, longitude, _class);
    }

}
