package requestModel.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestModel.UserLoginRequestModel;
import responseModel.Event.EventItemResponseModel;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserLoginRequestTest {

    @BeforeEach
    void setUp() {
    }
    UserLoginRequestModel test_event = new UserLoginRequestModel("Mike", "123");

    @Test
    void Event_Test_GetUsername(){
        assertNotNull(test_event.getUsername());
        assertTrue(test_event.getUsername().equals("Mike"));
    }

    @Test
    void Event_test_getPassword(){
        assertNotNull(test_event.getPassword());
        assertTrue(test_event.getPassword().equals("123"));
    }
}
