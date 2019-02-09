package com.example.mapper;

import com.example.model.input.ExampleInput;
import com.example.model.output.ExampleOutput;
import com.example.model.request.ExampleRequest;
import com.example.model.response.ExampleResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Component
public class ExampleRestMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(ExampleRequest.class, ExampleInput.class)
                .byDefault()
                .register();

        factory.classMap(ExampleOutput.class, ExampleResponse.class)
                .byDefault()
                .register();

    }
}
