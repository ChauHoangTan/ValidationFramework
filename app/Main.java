package app;
import framework.ui.FormSubmit;
import validation.observerNotification.SubjectNotification;
public class Main {
    public static void main(String[] args) {
        
        // User user = new User("", "");
        // User user = new User("", "" , "200", "1231231231", "chauhoangtan@gmail.com");

        // Validations validations = Validations.getInstance();
        // validations.validates(user);

        FormSubmit ui = new FormSubmit();
        SubjectNotification notification = SubjectNotification.getInstance();
        notification.attach(ui);
    }
}
