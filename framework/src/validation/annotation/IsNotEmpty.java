package validation.annotation;

import java.lang.annotation.*;

import validation.customeValidate.CustomeValidate;
import validation.customeValidate.DefaultValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsNotEmpty {
    public String message() default "Field is required!";
    
    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}
