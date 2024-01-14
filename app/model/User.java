package app.model;

import app.customeValidate.EmailValidate;
// import validation.annotation.IsNotEmpty;
// import validation.annotation.IsPhoneNumber;
import validation.annotation.*;

public class User {

    @IsNotEmpty ( message =  "Username is Required!")
    @IsNoWhitespace
    private String userName;

    @IsNotEmpty ( message = "Password is required!")
    @IsNoWhitespace
    @IsRegex ( regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" )
    // 1 letter up/low, 1 number, 1 special char, 8 < length < 20

    private String password;

    @IsPhoneNumber
    private String phoneNumber;

    @IsNumber
    @IsMinValue( value = 10 )
    @IsMaxValue( value = 100 )
    private String age;

    @IsNotEmpty 
    @IsEmailAddress ()
    @IsNoWhitespace
    private String emailAddress;


    public User(String userName, String password, String age, String phoneNumber, String emailAddress) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

}
