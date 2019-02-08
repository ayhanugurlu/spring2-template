package com.example.mapper;

import com.example.model.input.ExampleInput;
import com.example.model.request.ExampleRequest;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
public class ExampleRestMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(ExampleRequest.class, ExampleInput.class)
                .byDefault()
                .register();

    }
}
