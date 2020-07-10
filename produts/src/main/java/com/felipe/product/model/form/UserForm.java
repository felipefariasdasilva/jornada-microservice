package com.felipe.product.model.form;

import com.felipe.product.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserForm {

    @NotNull
    private String name;

    @NotNull
    private String email;

    public User convert() {
        return new User(name, email);
    }
}
