package validation.factory;

import java.util.HashMap;
import java.util.Map;

import validation.Validation;
import validation.ValidationType;
import validation.impl.IsNotEmptyValidation;
import validation.impl.IsPhoneNumberValidation;

public class ValidationFactory{
    private static Map<String, Validation> validationList = new HashMap<String, Validation>();

    public static Validation createValidation(String typeValidation, Validation childValidation){
        Validation validation = validationList.get(typeValidation);

        if(validation == null){
            switch (typeValidation) {
                case ValidationType.isNotEmpty:
                    validation = new IsNotEmptyValidation(childValidation);
                    break;
                case ValidationType.isPhoneNumber:
                    validation = new IsPhoneNumberValidation(childValidation);
                    break;
                default:
                    break;
            }

            validationList.put(typeValidation, validation);
        }

        return validation;
    }
}