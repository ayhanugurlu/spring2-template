package com.example.service;

import com.example.data.model.Example;
import com.example.service.exeption.ExampleException;
import com.example.service.model.input.ExampleInput;
import com.example.service.model.output.ExampleOutput;
import com.example.data.repository.ExampleRepository;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    private static Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);

    @Autowired
    ExampleRepository exampleRepository;

    @Autowired
    @Qualifier(value = "exampleServiceMapper")
    MapperFacade mapperFacade;



    public ExampleOutput exampleServiceSave(ExampleInput exampleInput) {
        logger.debug("exampleServiceSave method start");
        Example example =  mapperFacade.map(exampleInput,Example.class);
        exampleRepository.save(example);
        ExampleOutput exampleOutput =  mapperFacade.map(example,ExampleOutput.class);
        logger.debug("exampleServiceSave method finish");
        return exampleOutput;
    }

    public List<ExampleOutput> exampleServiceGetAll() {
        logger.debug("exampleServiceGetAll method start");
        List<Example>  examples =  exampleRepository.findAll();
        List<ExampleOutput> result =  examples.stream().map(example->{
            return mapperFacade.map(example,ExampleOutput.class);
        }).collect(Collectors.toList());
        logger.debug("exampleServiceGetAll method finish");
        return result;
    }

    public Optional<ExampleOutput> exampleServiceGetOne(Long id) {
        logger.debug("exampleServiceGetOne method start");
        Optional<Example> example =  exampleRepository.findById(id);
        ExampleOutput exampleOutput = null;
        if(example.isPresent()){
            exampleOutput = mapperFacade.map(example.get(),ExampleOutput.class);
        }
        final Optional<ExampleOutput> exampleOutputOptional = Optional.ofNullable(exampleOutput);
        logger.debug("exampleServiceGetOne method finish");
        return exampleOutputOptional;
    }

    @Override
    public void exampleExceptionService() throws ExampleException {
        throw new ExampleException("Example Exception");
    }
}
