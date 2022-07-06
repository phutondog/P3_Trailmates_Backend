package com.revature.trailmates.user;

import com.revature.trailmates.user.dtos.requests.EditUserRequest;
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

    public User UpdateUser(EditUserRequest request){
        User currentUser = userRepository.getUserByID(request.getId());

        boolean isPasswordChanged = false;

        if (!request.getEmail().equals("")) currentUser.setEmail(request.getEmail());

//        if (!request.getPassword().equals("")){
//            isPasswordChanged = true;
//            currentUser.setPassword(request.getPassword());
//        }

        if (!request.getBio().equals("")) currentUser.setBio(request.getBio());

        if (request.getAge() > 13) currentUser.setAge(request.getAge());

//        if (!request.getRole_id().equals("")){
//            boolean roleExists = new UserRolesService(new UserRolesDAO()).getExistsInColumnByStringValue("id", request.getRole_id());
//            if (roleExists == false)
//                throw new InvalidRequestException("Role type doesn't exist! Canceled modification.");
//            else
//                currentUser.setRole_id(request.getRole_id());
//        }

        //currentUser.setIs_active(request.isIs_active());

        userRepository.updateUser(currentUser.getEmail(), currentUser.getBio(), currentUser.getAge(), currentUser.getId());//, isPasswordChanged);
        currentUser.setPassword("");
        return currentUser;
    }


}
