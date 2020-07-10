package com.felipe.product.controller;

import com.felipe.product.model.User;
import com.felipe.product.model.dto.UserDTO;
import com.felipe.product.model.form.UserForm;
import com.felipe.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserDTO> getUsers(){

        List<User> users = userRepository.findAll();
        System.out.println(users.size());
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user: users) {
            userDTOS.add(new UserDTO(user));
        }

        return userDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsersById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postUsers(@RequestBody UserForm userForm, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("json: "+userForm.toString());
        User user = userForm.convert();
        userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
