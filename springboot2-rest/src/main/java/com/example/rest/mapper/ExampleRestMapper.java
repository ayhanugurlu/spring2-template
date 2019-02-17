package com.example.rest.mapper;

import com.example.rest.model.request.ExampleRequest;
import com.example.rest.model.response.ExampleResponse;
import com.example.service.model.input.ExampleInput;
import com.example.service.model.output.ExampleOutput;
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
