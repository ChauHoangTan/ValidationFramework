package validation.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import validation.Validation;
import validation.annotation.IsRegex;

public class IsRegexValidation extends Validation{

    @Override
    protected Boolean isValid(String value, Field field) {
        String regex = field.getAnnotation(IsRegex.class).regex();
        return Pattern.compile(regex).matcher(value).matches();
    }
    
}
