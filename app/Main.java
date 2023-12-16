package app;
import app.model.User;
import validation.Validation;
import validation.Validations;
import validation.ValidationResult.ValidationResult;
import validation.impl.IsNotEmptyValidation;
import validation.impl.IsPhoneNumberValidation;
public class Main {
    public static void main(String[] args) {
        
        User user = new User("", "");

        Validations validations = Validations.getInstance();
        validations.validates(user);
    }
}
