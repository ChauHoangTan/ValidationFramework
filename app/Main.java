package app;
import validation.Validation;
import validation.ValidationResult.ValidationResult;
import validation.impl.IsNotEmptyValidation;
import validation.impl.IsPhoneNumberValidation;
public class Main {
    public static void main(String[] args) {
        Validation isNotEmptyValidation = new IsNotEmptyValidation();
        Validation isPhoneNumberValidation = new IsPhoneNumberValidation(isNotEmptyValidation);

        ValidationResult result = isPhoneNumberValidation.validate("1231231231", "name");
        if(result.isValid()){
            System.out.println("Valid");
        }else{
            System.out.println(result.getReason());
        }
    }
}
