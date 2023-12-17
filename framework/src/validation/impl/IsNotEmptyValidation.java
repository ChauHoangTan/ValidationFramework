package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsNotEmpty;

public class IsNotEmptyValidation extends Validation {

    public IsNotEmptyValidation() {

    }

    public IsNotEmptyValidation(Validation validation) {
        this.childValidation = validation;
    }

    @Override
    protected String getReason(Field field) {
        IsNotEmpty annotation = field.getAnnotation(IsNotEmpty.class);
        return annotation.message();
    }

    // self decorator
    @Override
    protected Boolean isValid(String value) {
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
