package com.example.data.repository;

import com.example.data.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
public interface ExampleRepository extends JpaRepository<Example,Long> {
}
