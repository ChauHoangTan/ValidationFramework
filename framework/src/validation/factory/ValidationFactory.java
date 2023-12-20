package validation.factory;

import java.util.HashMap;
import java.util.Map;

import validation.Validation;
import validation.ValidationType;
import validation.annotation.IsNumber;
import validation.impl.*;

public class ValidationFactory{
    private static Map<String, Validation> validationList = new HashMap<String, Validation>();

    public static Validation createValidation(String typeValidation){
        Validation validation = validationList.get(typeValidation);

        if(validation == null){
            switch (typeValidation) {
                case ValidationType.isNotEmpty:
                    validation = new IsNotEmptyValidation();
                    break;
                case ValidationType.isPhoneNumber:
                    validation = new IsPhoneNumberValidation();
                    break;
                case ValidationType.isEmailAddress:
                    validation = new IsEmailAddressValidation();
                    break;
                case ValidationType.isNoWhitespace:
                    validation = new IsNoWhitespaceValidation();
                    break;
                case ValidationType.isMaxLength:
                    validation = new IsMaxLengthValidation();
                    break;
                case ValidationType.isMinLength:
                    validation = new IsMinLengthValidation();
                    break;
                case ValidationType.isMaxValue:
                    validation = new IsMaxValueValidation();
                    break;
                case ValidationType.isMinValue:
                    validation = new IsMinValueValidation();
                    break;
                case ValidationType.IsRegex:
                    validation = new IsRegexValidation();
                    break;
                case ValidationType.IsNumber:
                    validation = new IsNumberValidation();
                    break;
                default:
                    break;
            }

            validationList.put(typeValidation, validation);
        }

        return validation;
    }
}