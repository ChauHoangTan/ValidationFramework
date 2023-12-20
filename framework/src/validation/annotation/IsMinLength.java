package validation.annotation;

import java.lang.annotation.*;

import validation.customeValidate.CustomeValidate;
import validation.customeValidate.DefaultValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsMinLength {
    public int value() default 1;
    public String message() default "Field must have a minimum length";

    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}
