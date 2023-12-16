package validation.impl;

import validation.Validation;

public class IsPhoneNumberValidation extends Validation{


    public IsPhoneNumberValidation(){

    }

    public IsPhoneNumberValidation(Validation validation){
        this.childValidation = validation;
    }

    @Override
    protected String getReason(String field) {
        return field + " is not phone number!";

    }

    @Override
    protected Boolean isValid(String value) {
        return value.length() == 10 && value.matches("[0-9]+");
    }
    
}
