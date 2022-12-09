package Test.Entity.User;

import entity.User.CommonUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonUserTest {

    @BeforeAll
    public static void setUp() {

    }

    CommonUser TaskExample_1 = new CommonUser("mikewzh", "123", "Mike", "Wang");
    CommonUser TaskExample_2 = new CommonUser("stevenli", "5555sl", "Steven", "Li");

    // Test 1: Test the getUsername, getPassword, getFirstName, and getLastName methods on example 1.

    @Test
    void getUsername_test_example_1() {
        assertEquals("mikewzh", TaskExample_1.getUsername());
    }

    @Test
    void getPassword_test_example_1() {
        assertEquals("123", TaskExample_1.getPassword());
    }

    @Test
    void getFirstName_test_example_1() {
        assertEquals("Mike", TaskExample_1.getFirstName());
    }

    @Test
    void getLastName_test_example_1() {
        assertEquals("Wang", TaskExample_1.getLastName());
    }

    // Test 2: Test the getUsername, getPassword, getFirstName, and getLastName methods on example 2.

    @Test
    void getUsername_test_example_2() {
        assertEquals("stevenli", TaskExample_2.getUsername());
    }

    @Test
    void getPassword_test_example_2() {
        assertEquals("5555sl", TaskExample_2.getPassword());
    }

    @Test
    void getFirstName_test_example_2() {
        assertEquals("Steven", TaskExample_2.getFirstName());
    }

    @Test
    void getLastName_test_example_2() {
        assertEquals("Li", TaskExample_2.getLastName());
    }
}