package entities.Event;

import entity.Event.CommonEventItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonEventItemTest {

    @BeforeAll
    public static void setUp() {
        }
    CommonEventItem EventExample_1 = new CommonEventItem("playing video game", LocalDate.now(), LocalDate.now(),
            LocalTime.parse("13:00"), LocalTime.parse("14:00"));

    // Test: Test the getTitle, getStartDate, getEndDate, getStartTime, and getEndTime methods.

    @Test
    void getTitle_test_example_1() {
        assertEquals("playing video game", EventExample_1.getTitle());
    }

    @Test
    void getStartDate_test_example_1() {
        assertEquals(LocalDate.now(), EventExample_1.getStartDate());
    }

    @Test
    void getEndDate_test_example_1() {
        assertEquals(LocalDate.now(), EventExample_1.getEndDate());
    }

    @Test
    void getStartTime_test_example_1() {
        assertEquals(LocalTime.parse("13:00"), EventExample_1.getStartTime());
    }

    @Test
    void getEndTime_test_example_1() {
        assertEquals(LocalTime.parse("14:00"), EventExample_1.getEndTime());
    }
}