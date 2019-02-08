package com.example.mapper;

import com.example.model.Example;
import com.example.model.input.ExampleInput;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Component
public class ExampleServiceMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(ExampleInput.class, Example.class)
                .byDefault()
                .register();

    }
}
