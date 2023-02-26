package com.spring.boot.demo.app.services;

import com.spring.boot.demo.app.adapters.CityAdapter;
import com.spring.boot.demo.app.entities.CityEntity;
import com.spring.boot.demo.app.models.requests.CityRequest;
import com.spring.boot.demo.app.models.responses.CityResponse;
import com.spring.boot.demo.app.repositories.CityRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CityJPAService
{
    //Initialize Log4j instance
    private static final Logger Log = Logger.getLogger(CityJPAService.class.getName());

    @Autowired
    private CityRepository cityRepository;


    public List<CityResponse> getAll()
    {
        List<CityEntity> cityEntities = cityRepository.findAll();

        List<CityResponse> cities = new ArrayList<>();

        for (CityEntity cityEntity : cityEntities)
        {
            cities.add(CityAdapter.convertEntityToResponse(cityEntity));
        }

        return cities;
    }

    public CityResponse getByKey(String key)
    {
        Optional<CityEntity> cityEntity = cityRepository.findById(key);

        if (cityEntity.isEmpty())
        {
            return null;
        }

        return CityAdapter.convertEntityToResponse(cityEntity.get());
    }

    public CityResponse insert(CityRequest cityRequest)
    {
        CityResponse savedCityResponse = CityAdapter.convertEntityToResponse(cityRepository.save(CityAdapter.convertRequestToEntity(cityRequest)));

        return savedCityResponse;
    }

    public CityResponse update(CityRequest cityRequest)
    {
        CityResponse updatedCityResponse = CityAdapter.convertEntityToResponse(cityRepository.save(CityAdapter.convertRequestToEntity(cityRequest)));

        return updatedCityResponse;
    }

    public CityResponse delete(String key)
    {
        Optional<CityEntity> cityEntity = cityRepository.findById(key);

        if (cityEntity.isEmpty())
        {
            return null;
        }

        cityRepository.deleteById(key);

        CityResponse deletedCityResponse = CityAdapter.convertEntityToResponse(cityEntity.get());

        return deletedCityResponse;
    }
}
