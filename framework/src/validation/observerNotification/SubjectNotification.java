package validation.observerNotification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubjectNotification {

    private List<Observer> observers = null;
    private static SubjectNotification instance = null;

    private SubjectNotification() {

    }

    public static SubjectNotification getInstance() {
        if (instance == null) {
            instance = new SubjectNotification();
        }

        return instance;
    }

    public void notifyToObserver(HashMap<String,String> errrorList) {
        if (observers != null) {
            for (Observer observer : observers) {
                observer.update(errrorList);
            }
        }

    }

    public void attach(Observer observer) {
        if(observers == null){
            this.observers = new ArrayList<>();
        }
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        if(observers != null){
            this.observers.remove(observer);
        }
        
    }
}
