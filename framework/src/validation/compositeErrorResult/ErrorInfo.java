package validation.compositeErrorResult;

public class ErrorInfo implements IComponent{
    private String fieldName;
    
    private String reason;

    public ErrorInfo(String reason){
        this.reason = reason;
    }

    public ErrorInfo(String fieldName, String reason){
        this.fieldName = fieldName;
        this.reason = reason;
    }

    @Override
    public void execute(){
        System.out.print(fieldName + " InValid: " + reason + "\n");
    }
}
