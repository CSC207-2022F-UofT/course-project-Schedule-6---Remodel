package entities.Task;

import entity.Task.CommonTask;
import entity.Task.CommonTaskFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommonTaskFactoryTest {

    @BeforeAll
    public static void setUp() {
    }
    CommonTaskFactory test_example_1 = new CommonTaskFactory();

    CommonTaskFactory test_example_2 = new CommonTaskFactory();

    // In order to test the CommonTaskFactory, we only need to test if the type of the return is the same type as the
    // CommonTask class.

    @Test
    void Task_create_test_example_1() {
        assertNotNull(test_example_1.create("cooking", "2023-2-12", "other"));
        assertTrue(test_example_1.create("cooking", "2023-2-12", "other") instanceof CommonTask);
    }

    @Test
    void Task_create_test_example_2() {
        assertNotNull(test_example_2.create("a", "s", "d"));
        assertTrue(test_example_2.create("a", "s", "d") instanceof CommonTask);
    }

}
