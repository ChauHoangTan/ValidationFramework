package validation.observerNotification;

import java.util.List;

import validation.compositeErrorResult.IComponent;

public class SubjectNotification {

    private List<Observer> observers = null;
    private static SubjectNotification instance = null;

    private SubjectNotification(){

    }

    public static SubjectNotification getInstance(){
        if(instance == null){
            instance = new SubjectNotification();
        }

        return instance;
    }

    public void notifyToObserver(List<IComponent> list){
        if(observers != null){
            for (Observer observer : observers) {
                observer.update(list);
        }
        }
        
    }


    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void detach(Observer observer){
        this.observers.remove(observer);
    }
}
