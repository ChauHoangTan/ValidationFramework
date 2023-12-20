package validation.observerNotification;


import java.util.HashMap;

public interface Observer {
    public abstract void update(HashMap<String,String> errorList);
}
