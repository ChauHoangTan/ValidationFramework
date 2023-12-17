package validation.factory;

import java.util.HashMap;
import java.util.Map;

import validation.Validation;
import validation.ValidationType;
import validation.impl.*;

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
                case ValidationType.isMaxLength:
                    validation = new IsMaxLengthValidation(childValidation);
                    break;
                case ValidationType.isMinLength:
                    validation = new IsMinLengthValidation(childValidation);
                    break;
                case ValidationType.isMaxValue:
                    validation = new IsMaxValueValidation(childValidation);
                    break;
                case ValidationType.isMinValue:
                    validation = new IsMinValueValidation(childValidation);
                    break;
                default:
                    break;
            }

            validationList.put(typeValidation, validation);
        }

        return validation;
    }
}