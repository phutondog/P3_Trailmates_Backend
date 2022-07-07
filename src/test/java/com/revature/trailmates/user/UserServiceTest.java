package com.revature.trailmates.user;

import com.revature.trailmates.auth.AuthService;
import com.revature.trailmates.auth.dtos.requests.LoginRequest;
import com.revature.trailmates.auth.dtos.requests.NewUserRequest;
import com.revature.trailmates.user.dtos.requests.EditUserRequest;
import com.revature.trailmates.util.custom_exception.InvalidRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Spy
    EditUserRequest editUserRequest;

    @Test
    void getUserByUsername() {
    }

    @Test
    void updateUser() {
        editUserRequest = new EditUserRequest();

        editUserRequest.setId("1");
        editUserRequest.setUsername("foo");
        editUserRequest.setPassword("123");
        editUserRequest.setEmail("email@email.net");
        editUserRequest.setAge(12);
        editUserRequest.setBio("I'm the guy");
        editUserRequest.setRole("DEFAULT");

        try {
            //Setup:
            when( userService.UpdateUser( anyString(), any(EditUserRequest.class) ) )
                    .thenThrow(InvalidRequestException.class);
            //Method
            userService.UpdateUser("0", editUserRequest);
            System.out.println("Succeeded?!");
        }catch(Exception e){
            System.out.println("Exception occured " + e.getClass());
            assertFalse(e instanceof InvalidRequestException);
        }


        /*
        loginRequest.setUsername("test");
        loginRequest.setPassword("test");

        //Mockito.verify(loginRequest).setUsername("test");

        User dummy = new User();
        dummy.setUsername("test");

        when(userRepository.getUserByUsername(loginRequest.getUsername())).thenReturn(dummy);
        assertEquals(dummy, authService.login(loginRequest));*/
    }
/*


    @Test
    void register() {
        newUserRequest.setUsername("test");

        Exception exception = assertThrows(RuntimeException.class, () -> authService.register(newUserRequest));
        String expectedMessage = " is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isValidEmail() {

    }
 */

}