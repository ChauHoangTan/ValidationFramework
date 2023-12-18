package validation.compositeErrorResult;

import java.util.ArrayList;
import java.util.List;

import validation.observerNotification.SubjectNotification;

public class SubjectComposite implements IComponent{
    private List<IComponent> listInvalid;
    
    private static IComponent instance = null;

    // private List<Observer> observers;

    public SubjectComposite(){
        listInvalid = new ArrayList<>();
    }

    @Override
    public void execute(){
        if (listInvalid == null)
            return;
        for(IComponent e : listInvalid)
            e.execute();
        
        SubjectNotification notification = SubjectNotification.getInstance();
        notification.notifyToObserver(listInvalid);
    }

    public void add(IComponent errorResult){
        listInvalid.add(errorResult);
    }

    public void clearAll(){
        listInvalid.clear();
    }
}
