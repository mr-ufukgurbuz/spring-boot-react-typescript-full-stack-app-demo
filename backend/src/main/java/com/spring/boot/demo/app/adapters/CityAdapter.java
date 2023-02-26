package com.spring.boot.demo.app.adapters;

import com.spring.boot.demo.app.entities.CityEntity;
import com.spring.boot.demo.app.models.requests.CityRequest;
import com.spring.boot.demo.app.models.responses.CityResponse;

public class CityAdapter
{
    public static CityResponse convertEntityToResponse(CityEntity cityEntity)
    {
        return new CityResponse(cityEntity.getId(), cityEntity.getCode(), cityEntity.getName(), cityEntity.getLatitude(), cityEntity.getLongitude(), cityEntity.get_class());
    }

    public static CityEntity convertRequestToEntity(CityRequest cityRequest)
    {
        return new CityEntity(cityRequest.getKey(), cityRequest.getCode(), cityRequest.getName(), cityRequest.getLatitude(), cityRequest.getLongitude(), cityRequest.get_class());
    }

}
