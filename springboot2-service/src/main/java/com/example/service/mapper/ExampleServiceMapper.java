package com.example.service.mapper;

import com.example.data.model.Example;
import com.example.service.model.input.ExampleInput;
import com.example.service.model.output.ExampleOutput;
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

        factory.classMap(Example.class, ExampleOutput.class)
                .byDefault()
                .register();
    }
}
