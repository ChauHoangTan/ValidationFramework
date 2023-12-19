package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsMaxLength;

public class IsMaxLengthValidation extends Validation {

    public IsMaxLengthValidation(){

    }

    public IsMaxLengthValidation(Validation validation){
        this.childValidation = validation;
    }

    @Override
    protected String getReason(Field field) {
        IsMaxLength annotation = field.getAnnotation(IsMaxLength.class);
        return annotation.message();
    }

    // self decorator
    
    private Boolean isValid(String value) {
        if(value.trim().length() > 255){
            return false;
        }
        return true;
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        if (field == null)
            return isValid(value);
        if(value.trim().length() > field.getAnnotation(IsMaxLength.class).value()){
            return false;
        }
        return true;
    }

    
}
