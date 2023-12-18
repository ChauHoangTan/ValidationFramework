package app.model;

// import validation.annotation.IsNotEmpty;
// import validation.annotation.IsPhoneNumber;
import validation.annotation.*;;

public class User {

    @IsNotEmpty ( message =  "Is Required!")
    @IsNoWhitespace
    private String name;

    @IsNotEmpty
    @IsPhoneNumber
    private String phoneNumber;

    @IsNotEmpty
    @IsEmailAddress
    @IsNoWhitespace
    private String emailAddress;

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

    public User(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }


    public User(String maxLengthField, String minLengthField, String maxValue, String minValue) {
        this.maxLengthField = maxLengthField;
        this.minLengthField = minLengthField;
        this.maxValueField = maxValue;
        this.minValueField = minValue;
    }
}
