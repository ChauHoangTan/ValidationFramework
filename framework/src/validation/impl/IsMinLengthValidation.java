package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsMinLength;

public class IsMinLengthValidation extends Validation {


    // self decorator
    
    private Boolean isValid(String value) {
        if(value.trim().length() < 1){
            return false;
        }
        return true;
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        if (field == null)
            return isValid(value);
        if(value.trim().length() < field.getAnnotation(IsMinLength.class).value()){
            return false;
        }
        return true;
    }

    
}
