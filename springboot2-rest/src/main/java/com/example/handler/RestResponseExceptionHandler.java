package com.example.handler;


import com.example.exeption.ExampleException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by ayhanugurlu on 2/8/19.
 */
@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${error.code.header.key}")
    private String errorCodeHeaderKey;



    @ExceptionHandler({ExampleException.class})
    public ResponseEntity<ErrResponse> handleExampleException(HttpServletRequest request, ExampleException e) {

        String[] eCodes = {e.getErrorMessage()};
        ErrResponse response = new ErrResponse(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(errorCodeHeaderKey, eCodes)
                .body(response);
    }


}
