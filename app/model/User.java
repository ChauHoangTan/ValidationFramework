package app.model;

import validation.annotation.IsNotEmpty;
import validation.annotation.IsPhoneNumber;

public class User {

    @IsNotEmpty
    private String name;

    @IsNotEmpty
    @IsPhoneNumber
    private String phoneNumber;

    public User(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
