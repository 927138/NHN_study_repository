package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    private static final String MASK = "****";

    private final String id;
    @Setter
    private String password;

    private User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public static User create(String id, String password){
        return new User(id, password);
    }

    public static User createPasswordMasking(String id){
        return new User(id, MASK);
    }

}
