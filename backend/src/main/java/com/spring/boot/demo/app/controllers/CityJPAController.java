package com.spring.boot.demo.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.spring.boot.demo.app.models.responses.IResponse;
import com.spring.boot.demo.app.models.requests.CityRequest;
import com.spring.boot.demo.app.models.responses.CityResponse;
import com.spring.boot.demo.app.services.CityJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jpa/cities")
@CrossOrigin(origins = "http://localhost:3000")
public class CityJPAController
{
    @Autowired
    private CityJPAService cityJPAService;

    // RETRIEVE-ALL
    @GetMapping()
    public ResponseEntity<List<IResponse>> retrieveAllCities()
    {
        List<CityResponse> cities = cityJPAService.getAll();

        List<IResponse> cityResponses = new ArrayList<>(cities);

        return new ResponseEntity<>(cityResponses, HttpStatus.OK);
    }

    // RETRIEVE
    @GetMapping("{key}")
    public ResponseEntity<IResponse> retrieveCity(@PathVariable String key)
    {
        IResponse cityResponse = cityJPAService.getByKey(key);

        if (cityResponse == null)
        {
            //throw new EntityNotFoundException("cityKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }

    // CREATE
    @PostMapping()
    public ResponseEntity<IResponse> createCity(@Valid @RequestBody CityRequest cityRequest)
    {
        IResponse insertedCity = cityJPAService.insert(cityRequest);

        if (insertedCity == null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(insertedCity, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping()
    public ResponseEntity<IResponse> updateCity(@Valid @RequestBody CityRequest cityRequest)
    {
        IResponse updatedCity = cityJPAService.update(cityRequest);

        if (updatedCity == null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("{key}")
    public ResponseEntity<IResponse> deleteCity(@PathVariable String key)
    {
        IResponse deletedCity = cityJPAService.delete(key);

        if (deletedCity == null)
        {
            //throw new EntityNotFoundException("cityKey-" + key);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedCity, HttpStatus.OK);
    }

}