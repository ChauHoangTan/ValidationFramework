package app.model;

// import validation.annotation.IsNotEmpty;
// import validation.annotation.IsPhoneNumber;
import validation.annotation.*;;

public class User {

    @IsNotEmpty
    private String name;

    @IsNotEmpty
    @IsPhoneNumber
    private String phoneNumber;

    @IsNotEmpty
    @IsMaxLength
    private String maxLengthField;

    @IsNotEmpty
    @IsMinLength
    private String minLengthField;

    @IsNotEmpty
    @IsMaxValue
    private String maxValueField;

    @IsNotEmpty
    @IsMinValue
    private String minValueField;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User(String maxLengthField, String minLengthField, String maxValue, String minValue) {
        this.maxLengthField = maxLengthField;
        this.minLengthField = minLengthField;
        this.maxValueField = maxValue;
        this.minValueField = minValue;
    }
}
