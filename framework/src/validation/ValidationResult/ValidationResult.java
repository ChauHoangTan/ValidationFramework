package validation.ValidationResult;

public abstract class ValidationResult {
    
    public abstract boolean isValid();
    public abstract String getReason();

    public static ValidationResult valid(){
        return ValidValidationSingleton.getInstance();
    }

    public static ValidationResult inValid(String field, String reason){
        return new InvalidValidation(field, reason);
    }
}
