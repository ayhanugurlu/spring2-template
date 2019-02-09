package com.example;

import com.example.model.input.ExampleInput;
import com.example.model.output.ExampleOutput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * Created by ayhanugurlu on 2/9/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleServiceTest {


    @Autowired
    ExampleService exampleService;

    @Before
    public void setUp(){
    }


    @Test
    public void exampleServiceTest() {
        ExampleInput exampleInput = ExampleInput.builder().var1("var1").var2("var2").var3("var3").var4("var4").build();
        ExampleOutput exampleOutput = exampleService.exampleServiceSave(exampleInput);
        Assert.assertEquals(exampleOutput.getVar1(), exampleInput.getVar1());
        List<ExampleOutput> exampleOutputs = exampleService.exampleServiceGetAll();
        Assert.assertEquals(exampleOutputs.size(), 1);
        Optional<ExampleOutput>  exampleOutputOptional = exampleService.exampleServiceGetOne(exampleOutput.getId());
        Assert.assertEquals(exampleOutputOptional.isPresent(), true);
        Assert.assertEquals(exampleOutputOptional.get().getVar1(), exampleInput.getVar1());

    }


}
