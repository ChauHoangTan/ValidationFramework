package validation;
import java.lang.reflect.Field;

import validation.ValidationResult.ValidationResult;
import validation.factory.ValidationFactory;

import java.lang.annotation.Annotation;

public class Validations {
    
    private static Validations instance = null;

    private Validations(){

    }

    public static Validations getInstance(){
        if(instance == null){
            instance = new Validations();
        }
        return instance;
    }

    public void validates( Object object) {
        Class<?> classObject = object.getClass();
        Field[] fields = classObject.getDeclaredFields();


        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            Validation validation = null;
            for (Annotation annotation : annotations) {
                Validation newValidation = ValidationFactory.createValidation(TrimValidationType(annotation.annotationType().toString()), validation );
                validation = newValidation;
                // TrimValidationType(annotation.annotationType().toString());
            }
            try {
                Object valObject = field.get(object);
                ValidationResult result = validation.validate(valObject.toString(), field);
                if(result.isValid()){
                    System.out.println(field.getName() + " " + "Valid");
                }else{
                    System.out.println(result.getReason());
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            // validation.validate(field.get(object), field.getName());
        }
    }

    // Convert String from interface validation.annotation.IsNotEmpty into IsNotEmpty
    private String TrimValidationType(String name){
        int lastDotIndex = name.lastIndexOf(".");
        
        if (lastDotIndex != -1 && lastDotIndex < name.length() - 1) {
            return name.substring(lastDotIndex + 1);
        }

        return name;
    }
}
