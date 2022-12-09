package requestModel.Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestModel.TaskRequestModel;
import responseModel.Task.TaskResponseModel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskRequestModelTest {

    @BeforeEach
    void setUp() {
    }
    TaskRequestModel test_event = new TaskRequestModel("Finish testcases", "2022-12-12", "Fun");

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
