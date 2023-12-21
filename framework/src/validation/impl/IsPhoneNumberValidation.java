package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;

public class IsPhoneNumberValidation extends Validation{

    
    private Boolean isValid(String value) {
        return value.length() == 10 && value.matches("[0-9]+");
    }
    
    @Override
    protected Boolean isValid(String value, Field field) {
        return isValid(value);
    }
    
}
