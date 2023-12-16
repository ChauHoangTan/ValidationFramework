package validation;

import validation.ValidationResult.ValidationResult;

public abstract class Validation {

    protected Validation childValidation = null;

    public Validation(){

    }

    public Validation(Validation validation){

    }

    // self decorator
    // check if it has child validation, validate child fisrt then validate it
    public final ValidationResult validate(String value, String field){
        if(childValidation != null){
            ValidationResult chikValidationResult = childValidation.validate(value, field);
            if(chikValidationResult.isValid()){
                if(isValid(value)){
                    return ValidationResult.valid();
                }else{
                    return ValidationResult.inValid(field, getReason(field));
                }
            }else{
                if(isValid(value)){
                    return ValidationResult.inValid(field, chikValidationResult.getReason() );
                }else{
                    return ValidationResult.inValid(field, getReason(field) +"\n" + chikValidationResult.getReason());
                }
            }
        }else{
            if(isValid(value)){
                return ValidationResult.valid();
            }else{
                return ValidationResult.inValid(field, getReason(field));
            }
        }
        
    }
    // protected abstract String getField();

    protected abstract String getReason(String field);

    protected abstract Boolean isValid(String value);
}
