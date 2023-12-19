package validation.observerNotification;


import java.util.HashMap;
import java.util.List;

import validation.compositeErrorResult.ErrorInfo;

public interface Observer {
    public abstract void update(HashMap<String,String> errorList);
}
