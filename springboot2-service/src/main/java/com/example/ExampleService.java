package com.example;

import com.example.exeption.ExampleException;
import com.example.model.Example;
import com.example.model.input.ExampleInput;
import com.example.model.output.ExampleOutput;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
public interface ExampleService {
    ExampleOutput exampleServiceSave(ExampleInput exampleInput);

    List<ExampleOutput> exampleServiceGetAll();

    Optional<ExampleOutput> exampleServiceGetOne(Long id);

    void exampleExceptionService() throws ExampleException;
}
