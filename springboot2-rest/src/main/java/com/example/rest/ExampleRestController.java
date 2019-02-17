package com.example.rest;

import com.example.rest.model.request.ExampleRequest;
import com.example.rest.model.response.ExampleResponse;
import com.example.service.ExampleService;
import com.example.service.exeption.ExampleException;
import com.example.service.model.input.ExampleInput;
import com.example.service.model.output.ExampleOutput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@RestController
@RequestMapping("api/v1")
public class ExampleRestController {

    private static Logger logger = LoggerFactory.getLogger(ExampleRestController.class);

    @Autowired
    ExampleService exampleService;

    @Autowired
    @Qualifier(value = "exampleRestMapper")
    MapperFacade mapperFacade;

    @ApiOperation(value = "example rest save",
            notes = "example rest notes.<br/>")
    @PostMapping("exampleRest")
    public
    @ResponseBody
    ExampleResponse exampleRest(@ApiParam(value = "example rest request") @RequestBody ExampleRequest exampleRequest){
        logger.debug("exampleRest method start");
        ExampleInput exampleInput = mapperFacade.map(exampleRequest,ExampleInput.class);
        ExampleOutput exampleOutput =  exampleService.exampleServiceSave(exampleInput);
        ExampleResponse response = mapperFacade.map(exampleOutput,ExampleResponse.class);
        logger.debug("exampleRest method finish");
        return response;
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
