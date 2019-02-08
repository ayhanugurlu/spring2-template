package com.example.mapper;

import com.au.example.model.output.ExampleExtOutput;
import com.example.model.Example;
import com.example.model.input.ExampleInput;
import com.example.model.output.ExampleOutput;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Component
public class ExampleExtServiceMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(ExampleOutput.class,ExampleExtOutput.class)
                .byDefault()
                .register();
    }
}
