package validation.observerNotification;

import java.util.HashMap;
import java.util.List;

import validation.compositeErrorResult.ErrorInfo;
import validation.compositeErrorResult.IComponent;

public interface Observer {
    // public abstract void update(HashMap<?,?> listError);

    public abstract void update(List<IComponent> listError);
}
