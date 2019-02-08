package com.example.model.response;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Data
public class ExampleResponse {
    String var1;
    String var2;
    String var3;
    String var4;
}
