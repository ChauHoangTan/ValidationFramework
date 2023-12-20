package app.customeValidate;

import validation.customeValidate.CustomeValidate;

public class EmailValidate implements CustomeValidate{

    @Override
    public Boolean validate(String value) {
        if(value.length() < 5){
            return false;
        }
        return true;
    }
}
