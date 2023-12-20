package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;

public class IsNotEmptyValidation extends Validation {


    // self decorator
    
    private Boolean isValid(String value) {
        if (value.trim().length() == 0) {
            return false;
        }
        return true;
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        return isValid(value);
    }

}
