package validation.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import validation.Validation;

public class IsEmailAddressValidation extends Validation{

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    
    private Boolean isValid(String value) {
        return Pattern.compile(EMAIL_REGEX).matcher(value).matches();
    }

    @Override
    protected Boolean isValid(String value, Field field) {
        return isValid(value);
    }
    
}
