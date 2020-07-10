package com.felipe.product.model.form;

import com.felipe.product.model.User;

import javax.validation.constraints.NotNull;

public class UserForm {

    @NotNull
    private String name;

    @NotNull
    private String email;

    public User convert() {
        return new User(name, email);
    }
}
