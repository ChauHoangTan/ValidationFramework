package validation;

import java.lang.reflect.Field;

import validation.ValidationResult.ValidationResult;

public abstract class Validation {

    protected Validation childValidation = null;

    public Validation(){

    }

    public Validation(Validation validation){

    }

    // self decorator
    // check if it has child validation, validate child fisrt then validate it
    public final ValidationResult validate(String value, Field field){
        String fieldName = field.getName();
        if(childValidation != null){
            ValidationResult chikValidationResult = childValidation.validate(value, field);
            if(chikValidationResult.isValid()){
                if(isValid(value, field)){
                    return ValidationResult.valid();
                }else{
                    return ValidationResult.inValid(fieldName, getReason(field));
                }
            }else{
                if(isValid(value, field)){
                    return ValidationResult.inValid(fieldName, chikValidationResult.getReason() );
                }else{
                    return ValidationResult.inValid(fieldName, getReason(field) +"\n" + chikValidationResult.getReason());
                }
            }
        }else{
            if(isValid(value, field)){
                return ValidationResult.valid();
            }else{
                return ValidationResult.inValid(fieldName, getReason(field));
            }
        }
        
    }
    // protected abstract String getField();

    protected abstract String getReason(Field field);

    protected abstract Boolean isValid(String value, Field field);
}
