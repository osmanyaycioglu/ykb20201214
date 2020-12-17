package com.training.ykb.error;


public class RestException extends Exception {

    private static final long serialVersionUID = 6069358466251883839L;

    private final ErrorObj    err;

    public RestException(final ErrorObj errParam) {
        super();
        this.err = errParam;
    }


    public ErrorObj getErr() {
        return this.err;
    }

}
