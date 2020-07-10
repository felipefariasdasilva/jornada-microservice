package com.felipe.product.model.dto;

import com.felipe.product.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId().toString();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
