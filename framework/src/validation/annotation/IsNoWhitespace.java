package validation.annotation;

import java.lang.annotation.*;

import validation.customeValidate.CustomeValidate;
import validation.customeValidate.DefaultValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsNoWhitespace {
    public String message() default "Field must don't have white space!";
    
    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}