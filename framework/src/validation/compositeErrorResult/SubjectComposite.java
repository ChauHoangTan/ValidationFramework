// package validation.compositeErrorResult;

// import java.util.ArrayList;
// import java.util.List;

// import validation.observerNotification.SubjectNotification;

// public class SubjectComposite implements IComponent{
//     private List<ErrorInfo> listInvalid;
    
//     private static IComponent instance = null;

//     // private List<Observer> observers;

//     public SubjectComposite(){
//         listInvalid = new ArrayList<>();
//     }

//     @Override
//     public void execute(){
//         if (listInvalid == null)
//             return;
//         for(ErrorInfo e : listInvalid)
//             e.execute();
//         // listInvalid.execute();

//         // error implement [need fix]
//         // SubjectNotification notification = SubjectNotification.getInstance();
//         // notification.notifyToObserver(listInvalid); 
//     }

//     public void add(ErrorInfo errorResult){
//         listInvalid.add(errorResult);
//     }

//     public void clearAll(){
//         listInvalid.clear();
//     }
// }
