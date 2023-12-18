package validation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsMinValue {
    public double value() default Double.MIN_VALUE; 
    public String message() default "Field must have a value greater than or equal to the minimun value!";
}
