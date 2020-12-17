package com.training.ykb.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class RestErrorDecoder implements ErrorDecoder {

    @Autowired
    private GenericErrorHandler geh;

    @Override
    public RestException decode(final String methodKeyParam,
                                final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                ObjectMapper objectMapperLoc = new ObjectMapper();
                ErrorObj errorObjLoc = objectMapperLoc.readValue(responseParam.body()
                                                                              .asInputStream(),
                                                                 ErrorObj.class);
                return new RestException(errorObjLoc);
            } else {
                return new RestException(this.geh.getErrorObj()
                                                 .description("Rest API not found")
                                                 .cause(404));
            }
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return new RestException(this.geh.getErrorObj()
                                         .description("internal error while decoding error")
                                         .cause(300));
    }

}
