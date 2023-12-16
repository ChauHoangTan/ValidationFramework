package validation.factory;

import java.util.HashMap;
import java.util.Map;

import validation.Validation;
import validation.ValidationType;
import validation.impl.IsNotEmptyValidation;

public class ValidationFactory{
    private static Map<String, Validation> validationList = new HashMap<String, Validation>();

    public static Validation createValidation(String typeValidation){
        Validation validation = validationList.get(typeValidation);

        if(validation == null){
            switch (typeValidation) {
                case ValidationType.isNotEmptyType:
                    validation = new IsNotEmptyValidation();
                    break;
            
                default:
                    break;
            }
        }

        return validation;
    }
}