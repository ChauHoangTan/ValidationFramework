package validation.annotation;

import java.lang.annotation.*;

import validation.customeValidate.CustomeValidate;
import validation.customeValidate.DefaultValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsMaxLength {
    public int value() default 255;
    public String message() default "Field exceeds maximum length!";

    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}
