package validation.impl;

import validation.Validation;

public class IsNotEmptyValidation extends Validation {

    public IsNotEmptyValidation(){

    }

    public IsNotEmptyValidation(Validation validation){
        this.childValidation = validation;
    }

    @Override
    protected String getReason(String field) {
        return field + " is required";
    }

    // self decorator
    @Override
    protected Boolean isValid(String value) {
        if(value.trim().length() == 0){
            return false;
        }
        return true;
    }
    
}
