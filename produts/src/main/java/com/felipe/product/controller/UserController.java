package com.felipe.product.controller;

import com.felipe.product.model.User;
import com.felipe.product.model.form.UserForm;
import com.felipe.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getProducts() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postProducts(UserForm userForm, UriComponentsBuilder uriComponentsBuilder){

        User user = userForm.convert();
        userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity updateProducts() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteProducts() {
        return ResponseEntity.ok().build();
    }

}
