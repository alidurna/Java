package com.hoaxify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.shared.GenericMessage;

@RestController
public class UserController {

    @Autowired
    UserService UserService;
 
    @PostMapping("/api/v1/users")
    GenericMessage createUser(@RequestBody User user){
        UserService.save(user);
        return new GenericMessage("User is created");
    }
}




