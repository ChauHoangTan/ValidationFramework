package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsMinValue;

public class IsMinValueValidation extends Validation {


    // self decorator

    private Boolean isValid(String value) {
        try {
            if (Double.valueOf(value) < Double.MIN_VALUE)
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
            if (Double.valueOf(value) < field.getAnnotation(IsMinValue.class).value()) {
                return false;
            } else
                return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
