package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsNoWhitespace;

public class IsNoWhitespaceValidation extends Validation {

    public IsNoWhitespaceValidation(Validation chValidation){
        this.childValidation = chValidation;
    }

    @Override
    protected String getReason(Field field) {
        IsNoWhitespace isNoWhitespace = field.getAnnotation(IsNoWhitespace.class);
        return isNoWhitespace.message();
    }

    @Override
    protected Boolean isValid(String value) {
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
