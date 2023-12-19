package validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import validation.ValidationResult.ValidationResult;
import validation.compositeErrorResult.*;
import validation.factory.ValidationFactory;

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


        List<ErrorInfo> errorList = new ArrayList<>();


        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            Validation validation = null;
            for (Annotation annotation : annotations) {
                Validation newValidation = ValidationFactory
                        .createValidation(TrimValidationType(annotation.annotationType().toString()), validation);
                validation = newValidation;
            }
            try {
                Object valObject = field.get(object);
                ValidationResult result = validation.validate(valObject.toString(), field);
                if (result.isValid()) {
                    System.out.println(field.getName() + " " + "Valid");
                } else {
                    errorList.add(new ErrorInfo(field.getName(), result.getReason()));   
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        // test composite
        // errorList.execute();
        return;
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
