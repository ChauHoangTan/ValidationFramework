package app.model;

// import validation.annotation.IsNotEmpty;
// import validation.annotation.IsPhoneNumber;
import validation.annotation.*;;

public class User {

    @IsNotEmpty ( message =  "Username is Required!")
    @IsNoWhitespace
    private String userName;

    @IsNotEmpty ( message = "Password is required!")
    @IsNoWhitespace
    @IsRegex ( regex = "")
    private String password;

    @IsNotEmpty
    @IsPhoneNumber
    private String phoneNumber;

    @IsNumber
    @IsMinValue( value = 1 )
    @IsMaxValue( value = 100 )
    private String age;

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
    @IsMinValue (value = 0)
    private String minValueField;

    public User(String userName, String password, String age, String phoneNumber, String emailAddress) {
        this.userName = userName;
        this.password = password;
        this.age = age;
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
