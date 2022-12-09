package responseModel.Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoadTasksResponseModelTest{

    @BeforeEach
    void setUp() {
    }
    LoadTasksResponseModel test_event = new LoadTasksResponseModel(null);

    @Test
    void Event_Test_getAllTasks(){
        assertNotNull(test_event.getAllTasks());
        assertTrue(test_event.getAllTasks() == null);
    }
}
