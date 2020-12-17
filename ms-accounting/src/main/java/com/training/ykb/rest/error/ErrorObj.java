package com.training.ykb.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         subDomain;
    private String         boundedContext;
    private String         microservice;
    private String         description;
    private int            cause;


    public ErrorObj() {
    }


    public ErrorObj(final String subDomainParam,
                    final String boundedContextParam,
                    final String microserviceParam,
                    final String descriptionParam,
                    final int causeParam) {
        super();
        this.subDomain = subDomainParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.description = descriptionParam;
        this.cause = causeParam;
    }


    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj addSuberror(final ErrorObj err) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(err);
        return this;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public ErrorObj subDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObj boundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObj microservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public ErrorObj description(final String descriptionParam) {
        this.description = descriptionParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj cause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }


}
