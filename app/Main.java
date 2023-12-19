package app;
import app.model.User;
import validation.Validations;
public class Main {
    public static void main(String[] args) {
        
        // User user = new User("", "");
        User user = new User("", "" , "0", "1231231231", "chauhoangtan@gmail.com");

        Validations validations = Validations.getInstance();
        validations.validates(user);
    }
}
