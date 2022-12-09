package responseModel.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserLoginResponseModelTest{

    @BeforeEach
    void setUp() {
    }
    UserLoginResponseModel test_event = new UserLoginResponseModel("Login Successful");

    @Test
    void Event_test_getMessage(){
        assertNotNull(test_event.getMessage());
        assertTrue(test_event.getMessage().equals("Login Successful"));
    }
}