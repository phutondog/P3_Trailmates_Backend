package com.revature.trailmates.user;


//This is the class that wraps servlets for all netcode


import com.revature.trailmates.user.dtos.requests.EditUserRequest;
import com.revature.trailmates.util.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Inject
    private final UserService userService;

    @Inject
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/edit", consumes="application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User editUser(@RequestBody EditUserRequest request) {
        return userService.UpdateUser(request);
    }

    

}
