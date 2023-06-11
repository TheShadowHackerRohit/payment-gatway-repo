package com.example.practiceapis.Service;

import com.example.practiceapis.Model.User;
import com.example.practiceapis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(String name, String emailId) {

        User user = new User();
        user.setName(name);
        user.setEmailId(emailId);
        user.setAccountNumber(String.valueOf(UUID.randomUUID()));

        User savedUser = userRepository.save(user);

        return "user saved successfully with userId: "+ savedUser.getUserId();

    }


}
