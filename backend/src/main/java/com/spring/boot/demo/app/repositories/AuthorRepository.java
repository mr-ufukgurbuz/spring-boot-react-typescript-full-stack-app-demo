package com.spring.boot.demo.app.repositories;

import com.spring.boot.demo.app.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>
{

}
