package validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import validation.customeValidate.DefaultValidate;

import validation.customeValidate.CustomeValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface IsRegex {
    public String message() default "Regex is invalid!";

    public String regex() default "";
    
    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}
