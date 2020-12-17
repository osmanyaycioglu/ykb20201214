package com.training.ykb.rest.error;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericErrorHandler {

    @Value("${spring.application.name}")
    private String msName;
    @Value("${ms.boundedcontext}")
    private String bdName;
    @Value("${ms.subdomain}")
    private String sdName;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final IllegalArgumentException exp) {
        ErrorObj errorObjLoc = new ErrorObj().boundedContext(this.bdName)
                                             .microservice(this.msName)
                                             .subDomain(this.sdName)
                                             .description(exp.getMessage())
                                             .cause(101);
        return errorObjLoc;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final MethodArgumentNotValidException exp) {
        ErrorObj errorObjLoc = new ErrorObj().boundedContext(this.bdName)
                                             .microservice(this.msName)
                                             .subDomain(this.sdName)
                                             .description("Validation Error")
                                             .cause(101);
        List<ObjectError> allErrorsLoc = exp.getBindingResult()
                                            .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            ErrorObj subError = new ErrorObj().boundedContext(this.bdName)
                                              .microservice(this.msName)
                                              .subDomain(this.sdName)
                                              .description(objectErrorLoc.toString())
                                              .cause(102);
            errorObjLoc.addSuberror(subError);
        }
        return errorObjLoc;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(final Exception exp) {
        ErrorObj errorObjLoc = new ErrorObj().boundedContext(this.bdName)
                                             .microservice(this.msName)
                                             .subDomain(this.sdName)
                                             .description("Error obj")
                                             .cause(101);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(errorObjLoc);
    }
}
