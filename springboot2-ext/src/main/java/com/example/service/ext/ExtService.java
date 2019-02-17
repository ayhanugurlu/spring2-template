package com.example.service.ext;

import com.example.service.ext.model.output.ExampleExtOutput;

import java.util.Optional;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
public interface ExtService {

    Optional<ExampleExtOutput> exampleServiceGetOne(Long id);
}
