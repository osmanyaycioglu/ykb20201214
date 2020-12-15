package com.training.ykb.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyStartValidation implements ConstraintValidator<StartWith, String> {

    private StartWith sa;

    @Override
    public void initialize(final StartWith sa) {
        this.sa = sa;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.sa.value());
    }

}
