package com.example.service;

import com.example.service.exeption.ExampleException;
import com.example.service.model.input.ExampleInput;
import com.example.service.model.output.ExampleOutput;

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
