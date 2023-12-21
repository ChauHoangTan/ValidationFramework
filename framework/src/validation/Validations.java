package validation;

import java.lang.reflect.Field;
import java.util.HashMap;

import java.util.LinkedHashMap;

import validation.ValidationResult.ValidationResult;
import validation.factory.ValidationFactory;
import validation.observerNotification.SubjectNotification;

import java.lang.annotation.Annotation;

public class Validations {

    private static Validations instance = null;

    // private IComponent errorList;
    

    private Validations() {
        // errorList = new SubjectComposite();
    }

    public static Validations getInstance() {
        if (instance == null) {
            instance = new Validations();
        }
        return instance;
    }

    public void validates(Object object) {
        Class<?> classObject = object.getClass();
        Field[] fields = classObject.getDeclaredFields();
        // errorList.clear();


        HashMap<String, String> errorList = new LinkedHashMap<String, String>();


        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            Validation validation = null;
            for (Annotation annotation : annotations) {
                Validation newValidation = ValidationFactory
                        .createValidation(TrimValidationType(annotation.annotationType().toString()));
                newValidation.setChildValdation(validation);
                newValidation.setAnnotation(annotation);
                validation = newValidation;
            }
            // System.out.println(field.toString() + "   <>   " + annotations + "\n");
            try {
                Object valObject = field.get(object);
                ValidationResult result = validation.validate(valObject.toString(), field);
                if (result.isValid()) {
                    // System.out.println(field.getName() + " " + "Valid");
                } else {
                    errorList.put(field.getName(), result.getReason());   
                    // System.out.println(field.getName() + " " + "Invalid");
                    // System.out.println(result.getReason());

                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            // System.out.println(errorList);
            // System.out.println("\n");

        }

        // test composite
        // errorList.execute();

        // call Subject Observer
        SubjectNotification notification = SubjectNotification.getInstance();
        notification.notifyToObserver(errorList);
        // return errorList;
    }

    // Convert String from interface validation.annotation.IsNotEmpty into
    // IsNotEmpty
    private String TrimValidationType(String name) {
        int lastDotIndex = name.lastIndexOf(".");

        if (lastDotIndex != -1 && lastDotIndex < name.length() - 1) {
            return name.substring(lastDotIndex + 1);
        }

        return name;
    }
}
