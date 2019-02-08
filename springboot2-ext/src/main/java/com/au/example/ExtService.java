package com.au.example;

import com.au.example.model.input.ExampleExtInput;
import com.au.example.model.output.ExampleExtOutput;

import java.util.Optional;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
public interface ExtService {

    Optional<ExampleExtOutput> exampleServiceGetOne(Long id);
}
