package validation.ValidationResult;

public class InvalidValidation extends ValidationResult{
    private String field;
    private String reason;

    public InvalidValidation(String field, String reason){
        this.field = field;
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
