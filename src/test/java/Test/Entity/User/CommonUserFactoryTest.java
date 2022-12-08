package Test.Entity.User;

import entity.Event.CommonEventItem;
import entity.User.CommonUserFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonUserFactoryTest {

    @BeforeAll
    public static void setUp() {
    }

    CommonUserFactory test_example_1 = new CommonUserFactory();

    CommonUserFactory test_example_2 = new CommonUserFactory();

    // In order to test the CommonEventItemFactory, we only need to test if the type of the return is the same type as the
    // CommonEventItemFactory class.

    @Test
    void Task_create_test_example_1() {
        assertNotNull(test_example_1.create("mikewzh", "123", "Mike", "Wang"));
        assertTrue(test_example_1.create("mikewzh", "123", "Mike", "Wang")
                instanceof CommonEventItem);
    }

    @Test
    void Task_create_test_example_2() {
        assertNotNull(test_example_2.create("stevenli", "5555sl", "Steven", "Li"));
        assertTrue(test_example_2.create("stevenli", "5555sl", "Steven", "Li")
                instanceof CommonEventItem);
    }
}

