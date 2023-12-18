package validation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsNoWhitespace {
    public String message() default "Field must don't have white space!";
}