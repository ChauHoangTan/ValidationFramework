package validation.errorResult;

import java.util.ArrayList;
import java.util.List;

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
    }

    public void add(IComponent errorResult){
        listInvalid.add(errorResult);
    }

    public void clearAll(){
        listInvalid.clear();
    }
}
