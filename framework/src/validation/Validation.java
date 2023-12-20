package validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import validation.ValidationResult.ValidationResult;

public abstract class Validation {

    protected Validation childValidation = null;
    protected Annotation annotation = null;

    public Validation() {

    }

    public Validation(Validation validation) {

    }

    public void setChildValdation(Validation validation){
        this.childValidation = validation;
    }

    public void setAnnotation(Annotation annotation){
        this.annotation = annotation;
        

        // try {
        //     // Sử dụng reflection để lấy giá trị của thuộc tính message
        //     Method method = annotation.annotationType().getMethod("message");
        //     String message = (String)method.invoke(annotation);
        //     System.err.println();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    // self decorator
    // check if it has child validation, validate child fisrt then validate it
    public final ValidationResult validate(String value, Field field) {
        String fieldName = field.getName();
        if (childValidation != null) {
            ValidationResult chikValidationResult = childValidation.validate(value, field);

            if (chikValidationResult.isValid()) {
                if (isValid(value, field)) {
                    return ValidationResult.valid();
                } else {
                    return ValidationResult.inValid(fieldName, getReason());
                }
            } else {
                if (isValid(value, field)) {
                    return ValidationResult.inValid(fieldName, chikValidationResult.getReason());
                } else {
                    return ValidationResult.inValid(fieldName,
                            getReason() + "\n" + chikValidationResult.getReason());
                }
            }
        } else {
            if (isValid(value, field)) {
                return ValidationResult.valid();
            } else {
                return ValidationResult.inValid(fieldName, getReason());
            }
        }

    }
    // protected abstract String getField();

    protected String getReason(){
        try {
            // Sử dụng reflection để lấy giá trị của thuộc tính message
            Method method = annotation.annotationType().getMethod("message");
            String message = (String)method.invoke(annotation);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    protected abstract Boolean isValid(String value, Field field);
}
