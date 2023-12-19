package validation.compositeErrorResult;

import java.util.HashMap;
import java.util.Map;

// public class ErrorInfo implements IComponent{
public class ErrorInfo {
    private String fieldName;
    
    private String reason;

    public ErrorInfo(String fieldName, String reason){
        this.fieldName = fieldName;
        this.reason = reason;
    }

    public String getFieldName() {
        return fieldName;
    }
    
    public String getReason(){
        return reason;
    }
    
    public Map<String, String> getValue(){
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put(fieldName, reason);
        System.out.println("day" + valuesMap);
        return valuesMap;
    }

    // @Override
    // public void execute(){
    //     System.out.print(fieldName + " InValid: " + reason + "\n");
    // }
}
