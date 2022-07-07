package com.revature.trailmates.auth;

import com.revature.trailmates.auth.dtos.requests.LoginRequest;
import com.revature.trailmates.auth.dtos.requests.NewUserRequest;
import com.revature.trailmates.user.User;
import com.revature.trailmates.user.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @Spy
    LoginRequest loginRequest;

    @Spy
    NewUserRequest newUserRequest;

    @Test
    void loginSuccess() {
        // Arrange
        loginRequest.setUsername("testUser001");
        loginRequest.setPassword("P@ssw0rd");

        User dummy = new User();
        dummy.setUsername("testUser001");

        Mockito.when(userRepository.getUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword())).thenReturn(dummy);

        // Act
        User test = authService.login(loginRequest);

        // Assert
        assertEquals(dummy, test);
    }

    @Test
    void invalidUsername(){
        // Arrange
        loginRequest.setUsername("testUser001");
        loginRequest.setPassword("P@ssw0rd");

        // Act


        // Assert
    }

    @Test
    void invalidPassword(){
        // Arrange


        // Act


        // Assert
    }

    @Test
    void invalidEmail(){
        // Arrange


        // Act


        // Assert
    }

    @Test
    void usernameAlreadyExists(){
        // Arrange


        // Act


        // Assert
    }

    //Mockito.verify(loginRequest).setUsername("test");

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


}