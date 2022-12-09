package responseModel.Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TaskResponseModelTest{

    @BeforeEach
    void setUp() {
    }
    TaskResponseModel test_event = new TaskResponseModel("Finish testcases", "2022-12-12", "Fun");

    @Test
    void Event_Test_GetTitle(){
        assertNotNull(test_event.getDescription());
        assertTrue(test_event.getDescription().equals("Finish testcases"));
    }

    @Test
    void Event_Test_GetStartDate(){
        assertNotNull(test_event.getDate());
        assertTrue(test_event.getDate().equals("2022-12-12"));
    }

    @Test
    void Event_Test_GetCategory(){
        assertNotNull(test_event.getCategory());
        assertTrue(test_event.getCategory().equals("Fun"));
    }

}