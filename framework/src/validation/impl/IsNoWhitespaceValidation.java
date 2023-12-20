package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsNoWhitespace;

public class IsNoWhitespaceValidation extends Validation {


    
    private Boolean isValid(String value) {
        if(!value.contains(" ")){
            return true;
        }
        return false;
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        return isValid(value);
    }
    
}
