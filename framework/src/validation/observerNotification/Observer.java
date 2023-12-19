package validation.observerNotification;


import java.util.List;

import validation.compositeErrorResult.ErrorInfo;

public interface Observer {
    public abstract void update(List<ErrorInfo> listError);
}
