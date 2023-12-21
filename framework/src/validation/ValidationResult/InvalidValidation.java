package validation.ValidationResult;

public class InvalidValidation extends ValidationResult{
    private String reason;

    public InvalidValidation(String reason){
        this.reason = reason;
    }

    @Override
    public boolean isValid(){
        return false;
    }

    @Override
    public String getReason(){
        // return "Invalid " + field + "! " + reason ;
        return reason;
    }
}
