package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsMaxValue;

public class IsMaxValueValidation extends Validation {

    public IsMaxValueValidation(){

    }

    public IsMaxValueValidation(Validation validation){
        this.childValidation = validation;
    }

    @Override
    protected String getReason(Field field) {
        IsMaxValue annotation = field.getAnnotation(IsMaxValue.class);
        return annotation.message();
    }

    // self decorator
    
    private Boolean isValid(String value) {
        try {
            if (Double.valueOf(value) > Double.MAX_VALUE)
                return false;
            else
                return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        if (field == null)
            return isValid(value);
        try {
            if (Double.valueOf(value) > field.getAnnotation(IsMaxValue.class).value())
                return false;
            else
                return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
}
