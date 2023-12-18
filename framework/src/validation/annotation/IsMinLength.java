package validation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsMinLength {
    public int value() default 1;
    public String message() default "Field must have a minimum length";
}
