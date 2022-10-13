package com.sparta.assginment04.dto;

import lombok.Getter;
import org.intellij.lang.annotations.Pattern;

public class UserDto {

    @Getter
    public static class Signup {
        @Pattern("^[a-z0-9]{4,12}$")
        private String nickName;

        @Pattern("\"^(?=.*[a-zA-Z])(?=.*/d)(?=.*[~!@#$%^&*()+|=])[A-Za-z/d~!@#$%^&*()+|=]{8,20}$\"")
        private String password;
        private String passwordAgain;

    }
}
