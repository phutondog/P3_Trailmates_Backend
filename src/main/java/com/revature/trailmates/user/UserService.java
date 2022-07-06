package com.revature.trailmates.user;

import com.revature.trailmates.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;


//This is the class used for interacting with users.
public class UserService {

    @Inject
    private final UserRepository userRepository;


    @Inject
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }


}
