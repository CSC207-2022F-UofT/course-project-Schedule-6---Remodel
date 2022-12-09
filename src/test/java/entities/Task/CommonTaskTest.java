package entities.Task;

import entity.Task.CommonTask;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CommonTaskTest {

    @BeforeAll
    public static void setUp() {

    }
    CommonTask TaskExample_1 = new CommonTask("soccer", "2022-12-02", "sport");
    CommonTask TaskExample_2 = new CommonTask("assignment", "2022-05-15", "study");

    // Test 1: Test the getDescription, getDate, and getCategory methods on example 1.

    @Test
    void getDescription_test_example_1() {
        assertEquals("soccer", TaskExample_1.getDescription());
    }

    @Test
    void getDate_test_example_1() {
        assertEquals("2022-12-02", TaskExample_1.getDate());
    }

    @Test
    void getCategory_test_example_1() {
        assertEquals("sport", TaskExample_1.getCategory());
    }

    // Test 1: Test the getDescription, getDate, and getCategory methods on example 2.

    @Test
    void getDescription_test_example_2() {
        assertEquals("assignment", TaskExample_2.getDescription());
    }

    @Test
    void getDate_test_example_2() {
        assertEquals("2022-05-15", TaskExample_2.getDate());
    }

    @Test
    void getCategory_test_example_2() {
        assertEquals("study", TaskExample_2.getCategory());
    }

    // Test 2: Test the setDescription, setDate, and setCategory methods on example 1.

    @Test
    void setDescription_test_example_1() {
        TaskExample_1.setDescription("basketball");
        assertEquals("basketball", TaskExample_1.getDescription());
        assertNotEquals("soccer", TaskExample_1.getDescription());
    }

    @Test
    void setDate_test_example_1() {
        TaskExample_1.setDate("0000-00-00");
        assertEquals("0000-00-00", TaskExample_1.getDate());
        assertNotEquals("2022-12-02", TaskExample_1.getDate());
    }

    @Test
    void setCategory_test_example_1() {
        TaskExample_1.setCategory("game");
        assertEquals("game", TaskExample_1.getCategory());
        assertNotEquals("sport", TaskExample_1.getCategory());
    }

    // Test 2: Test the setDescription, setDate, and setCategory methods on example 2.

    @Test
    void setDescription_test_example_2() {
        TaskExample_2.setDescription("coding");
        assertEquals("coding", TaskExample_2.getDescription());
        assertNotEquals("assignment", TaskExample_2.getDescription());
    }

    @Test
    void setDate_test_example_2() {
        TaskExample_2.setDate("2012-02-08");
        assertEquals("2012-02-08", TaskExample_2.getDate());
        assertNotEquals("2022-05-15", TaskExample_2.getDate());
    }

    @Test
    void setCategory_test_example_2() {
        TaskExample_2.setCategory("practice");
        assertEquals("practice", TaskExample_2.getCategory());
        assertNotEquals("study", TaskExample_2.getCategory());
    }
}