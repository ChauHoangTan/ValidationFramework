package validation.impl;

import java.lang.reflect.Field;

import validation.Validation;
import validation.annotation.IsPhoneNumber;

public class IsPhoneNumberValidation extends Validation{


    public IsPhoneNumberValidation(){

    }

    public IsPhoneNumberValidation(Validation validation){
        this.childValidation = validation;
    }

    @Override
    protected String getReason(Field field) {
        IsPhoneNumber annotation = field.getAnnotation(IsPhoneNumber.class);
        return annotation.message();

    }

    @Override
    protected Boolean isValid(String value) {
        return value.length() == 10 && value.matches("[0-9]+");
    }
    
    @Override
    protected Boolean isValid(String value, Field field) {
        return isValid(value);
    }
    
}
