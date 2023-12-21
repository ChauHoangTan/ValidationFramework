package validation.annotation;

import java.lang.annotation.*;

import validation.customeValidate.CustomeValidate;
import validation.customeValidate.DefaultValidate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsMaxValue {
    public double value() default Double.MAX_VALUE; 
    public String message() default "Field must have a value less than or equal to the maximum value!";

    public Class<? extends CustomeValidate> validator() default DefaultValidate.class;
}
