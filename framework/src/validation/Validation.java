package validation;

import validation.ValidationResult.ValidationResult;

public abstract class Validation {
    // private String value;
    // private String reason;
    // private String field;

    public final ValidationResult validate(){
        if(isValid(getValue())){
            return ValidationResult.valid();
        }else{
            return ValidationResult.inValid(getField(), getReason());
        }
    }
    protected abstract String getField();

    protected abstract String getValue();

    protected abstract String getReason();

    protected abstract Boolean isValid(String value);
}
