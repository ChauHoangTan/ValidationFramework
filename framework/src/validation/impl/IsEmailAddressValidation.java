package validation.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import validation.Validation;
import validation.annotation.IsEmailAddress;

public class IsEmailAddressValidation extends Validation{

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public IsEmailAddressValidation(Validation chValidation){
        this.childValidation = chValidation;
    }

    @Override
    protected String getReason(Field field) {   
        IsEmailAddress isEmailAddress = field.getAnnotation(IsEmailAddress.class);
        return isEmailAddress.message();
    }

    
    private Boolean isValid(String value) {
        return Pattern.compile(EMAIL_REGEX).matcher(value).matches();
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        return isValid(value);
    }
    
}
