package com.example.rest;

import com.example.Springboot2RestApplication;
import com.example.model.request.ExampleRequest;
import com.example.model.response.ExampleResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import  org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
/**
 * Created by ayhanugurlu on 2/9/19.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2RestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleRestControllerTest {

    HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;


    @Test
    public void restTest() {

        RestTemplate restTemplate = new RestTemplate();

        ExampleRequest exampleRequest = ExampleRequest.builder().var1("var1").var2("var2").var3("var3").var4("var4").build();
        HttpEntity<ExampleRequest> exampleRequestHttpEntity = new HttpEntity<>(exampleRequest);
        ResponseEntity<ExampleResponse> exampleResponseResponseEntity = restTemplate.exchange(createURLWithPort("/exampleRest"), HttpMethod.POST, exampleRequestHttpEntity,
                ExampleResponse.class);
        Assert.assertEquals(exampleResponseResponseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(exampleResponseResponseEntity.getBody().getVar1(),"var1");


    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/api/v1" + uri;
    }


}
