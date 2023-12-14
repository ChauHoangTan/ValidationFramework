package validation.ValidationResult;

public class ValidValidationSingleton extends ValidationResult {
    private static ValidValidationSingleton instance = null;

    private ValidValidationSingleton(){

    }

    public static ValidValidationSingleton getInstance(){
        if(instance == null){
            instance = new ValidValidationSingleton();
        }

        return instance;
    }

    @Override
    public boolean isValid(){
        return true;
    }

    @Override
    public String getReason(){
        return "";
    }
}
