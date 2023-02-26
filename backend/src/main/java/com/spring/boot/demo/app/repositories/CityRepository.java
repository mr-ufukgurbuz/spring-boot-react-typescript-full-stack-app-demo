package com.spring.boot.demo.app.repositories;

import com.spring.boot.demo.app.entities.CityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<CityEntity, String>
{
}
