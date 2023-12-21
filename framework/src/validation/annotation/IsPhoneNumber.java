package validation.annotation;

import java.lang.annotation.*;

import validation.customeValidate.CustomeValidate;
import validation.customeValidate.DefaultValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsPhoneNumber {
    public String message() default "Field must be phone number!";
    
    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}
