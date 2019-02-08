package com.example.model.repository;

import com.example.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
public interface ExampleRepository extends JpaRepository<Example,Long> {
}
