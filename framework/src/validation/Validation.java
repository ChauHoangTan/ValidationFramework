package validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import validation.ValidationResult.ValidationResult;
import validation.customeValidate.CustomeValidate;

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

        try {
            // Sử dụng reflection để lấy giá trị của thuộc tính message
            Method validatorMethod = annotation.annotationType().getMethod("validator");
            Class<? extends CustomeValidate> validator = (Class<? extends CustomeValidate>)validatorMethod.invoke(annotation);
            CustomeValidate cValidate = validator.newInstance();          
            // if(TrimCustomeValidatorType(cValidate.getClass().toString()).equals("DefaultValidate")){
            //     System.err.println(false);
            // }else{
            //     System.out.println(true);
            // }
            // System.err.println(TrimCustomeValidatorType(cValidate.getClass().toString()));
            String fieldName = field.getName();
            if (childValidation != null) {
                ValidationResult childValidationResult = childValidation.validate(value, field);

                if (childValidationResult.isValid()) {
                    if(!TrimCustomeValidatorType(cValidate.getClass().toString()).equals("DefaultValidate")){
                        // System.err.println(cValidate.validate(value));
                        // System.err.println(true);
                        if( cValidate.validate(value)){
                            return ValidationResult.valid();
                        }else{
                            return ValidationResult.inValid(fieldName, getReason());
                        }
                    }else{
                        // System.err.println(false);
                        if (isValid(value, field)) {
                            return ValidationResult.valid();
                        } else {
                            return ValidationResult.inValid(fieldName, getReason());
                        }
                    }
                    
                } else {
                    if(!TrimCustomeValidatorType(cValidate.getClass().toString()).equals("DefaultValidate")){
                        // System.err.println(cValidate.validate(value));
                        // System.err.println(true);
                        if (cValidate.validate(value)) {
                            return ValidationResult.inValid(fieldName, childValidationResult.getReason());
                        } else {
                            return ValidationResult.inValid(fieldName,
                                    getReason() + "\n" + childValidationResult.getReason());
                        }
                    }else{
                        // System.err.println(false);
                        if (isValid(value, field)) {
                            return ValidationResult.inValid(fieldName, childValidationResult.getReason());
                        } else {
                            return ValidationResult.inValid(fieldName,
                                    getReason() + "\n" + childValidationResult.getReason());
                        }
                    }
                    
                }
            } else {
                
                // if (isValid(value, field)) {
                //     return ValidationResult.valid();
                // } else {
                //     return ValidationResult.inValid(fieldName, getReason());
                // }

                if(!TrimCustomeValidatorType(cValidate.getClass().toString()).equals("DefaultValidate")){
                    // System.err.println(cValidate.validate(value));
                    // System.err.println(true);
                    if (cValidate.validate(value)) {
                        return ValidationResult.valid();
                    } else {
                        return ValidationResult.inValid(fieldName, getReason());
                    }
                }else{
                    // System.err.println(false);
                    if (isValid(value, field)) {
                        return ValidationResult.valid();
                    } else {
                        return ValidationResult.inValid(fieldName, getReason());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ValidationResult.valid();

        // String fieldName = field.getName();
        // if (childValidation != null) {
        //     ValidationResult chikValidationResult = childValidation.validate(value, field);

        //     if (chikValidationResult.isValid()) {
        //         if (isValid(value, field)) {
        //             return ValidationResult.valid();
        //         } else {
        //             return ValidationResult.inValid(fieldName, getReason());
        //         }
        //     } else {
        //         if (isValid(value, field)) {
        //             return ValidationResult.inValid(fieldName, chikValidationResult.getReason());
        //         } else {
        //             return ValidationResult.inValid(fieldName,
        //                     getReason() + "\n" + chikValidationResult.getReason());
        //         }
        //     }
        // } else {
        //     if (isValid(value, field)) {
        //         return ValidationResult.valid();
        //     } else {
        //         return ValidationResult.inValid(fieldName, getReason());
        //     }
        // }

        

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

    private String TrimCustomeValidatorType(String name) {
        int lastDotIndex = name.lastIndexOf(".");

        if (lastDotIndex != -1 && lastDotIndex < name.length() - 1) {
            return name.substring(lastDotIndex + 1);
        }

        return name;
    }
}
