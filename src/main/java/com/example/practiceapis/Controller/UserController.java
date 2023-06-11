package com.example.practiceapis.Controller;


import com.example.practiceapis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestParam String name, @RequestParam String emailId){

        String response = userService.addUser(name,emailId);

        return  new ResponseEntity<>(response, HttpStatus.CREATED);

    }



}

