package validation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsMaxLength {
    public int value() default 255;
    public String message() default "Field exceeds maximum length!";
}
