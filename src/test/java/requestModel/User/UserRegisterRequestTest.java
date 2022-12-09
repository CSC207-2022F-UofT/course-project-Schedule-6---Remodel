package requestModel.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestModel.UserLoginRequestModel;
import requestModel.UserRegisterRequestModel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegisterRequestTest {

    @BeforeEach
    void setUp() {
    }
    UserRegisterRequestModel test_event = new UserRegisterRequestModel("n1", "123", "Nizar",
            "Abdouss");

    @Test
    void Event_Test_GetUsername(){
        assertNotNull(test_event.getUsername());
        assertTrue(test_event.getUsername().equals("n1"));
    }

    @Test
    void Event_test_getPassword(){
        assertNotNull(test_event.getPassword());
        assertTrue(test_event.getPassword().equals("123"));
    }

    @Test
    void Event_test_getFirstName(){
        assertNotNull(test_event.getFirstName());
        assertTrue(test_event.getFirstName().equals("Nizar"));
    }

    @Test
    void Event_test_getLastName(){
        assertNotNull(test_event.getLastName());
        assertTrue(test_event.getLastName().equals("Abdouss"));
    }
}
