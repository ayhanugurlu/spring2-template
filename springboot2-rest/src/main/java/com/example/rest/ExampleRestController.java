package com.example.rest;



import com.example.ExampleService;
import com.example.exeption.ExampleException;
import com.example.model.input.ExampleInput;
import com.example.model.request.ExampleRequest;
import com.example.model.response.ExampleResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@RestController
public class ExampleRestController {

    private static Logger logger = LoggerFactory.getLogger(ExampleRestController.class);

    @Autowired
    ExampleService exampleService;

    @Autowired
    @Qualifier(value = "exampleServiceMapper")
    MapperFacade mapperFacade;

    @ApiOperation(value = "example rest save",
            notes = "example rest notes.<br/>")
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    ExampleResponse exampleRest(@ApiParam(value = "example rest request") @RequestBody ExampleRequest exampleRequest){
        logger.debug("exampleRest method start");
        ExampleInput exampleInput = mapperFacade.map(exampleRequest,ExampleInput.class);
        exampleService.exampleServiceSave(exampleInput);
        logger.debug("exampleRest method finish");
        return new ExampleResponse();
    }


    @ApiOperation(value = "example rest exeption handling",
            notes = "example rest exeption handling notes.<br/>")
    @RequestMapping(value = "/handleException", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    void exampleRest() throws ExampleException {
        logger.debug("exampleRest method start");
        exampleService.exampleExceptionService();
        logger.debug("exampleRest method finish");
    }

}
