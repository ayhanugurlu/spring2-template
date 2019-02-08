package com.example;

import com.au.example.ExtService;
import com.au.example.model.output.ExampleExtOutput;
import com.example.model.output.ExampleOutput;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Service
public class ExampleExtServiceImpl implements ExtService {

    private static Logger logger = LoggerFactory.getLogger(ExampleExtServiceImpl.class);

    @Autowired
    @Qualifier(value = "exampleExtServiceMapper")
    MapperFacade mapperFacade;



    @Autowired
    ExampleService exampleService;


    public Optional<ExampleExtOutput> exampleServiceGetOne(Long id) {
        logger.debug("exampleServiceGetOne method start");
        Optional<ExampleOutput>  example = exampleService.exampleServiceGetOne(id);
        ExampleExtOutput exampleExtOutput = null;
        if(example.isPresent()){
            exampleExtOutput = mapperFacade.map(example,ExampleExtOutput.class);
        }
        Optional<ExampleExtOutput> optionalExampleExtOutput = Optional.ofNullable(exampleExtOutput);
        logger.debug("exampleServiceGetOne method finish");
        return optionalExampleExtOutput;
    }


}
