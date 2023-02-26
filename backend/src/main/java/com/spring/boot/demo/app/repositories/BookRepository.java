package com.spring.boot.demo.app.repositories;

import com.spring.boot.demo.app.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>
{

}
