package Test.Entity.Event;

import entity.Event.CommonEventItem;
import entity.Event.CommonEventItemFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonEventItemFactoryTest {
    @BeforeAll
    public static void setUp() {
    }
    CommonEventItemFactory test_example_1 = new CommonEventItemFactory();

    CommonEventItemFactory test_example_2 = new CommonEventItemFactory();

    // In order to test the CommonEventItemFactory, we only need to test if the type of the return is the same type as the
    // CommonEventItemFactory class.

    @Test
    void Task_create_test_example_1() {
        assertNotNull(test_example_1.create("playing video game",LocalDate.now(), LocalDate.now(),
                LocalTime.parse("13:00"), LocalTime.parse("14:00")));
        assertTrue(test_example_1.create("playing video game",LocalDate.now(), LocalDate.now(),
                LocalTime.parse("13:00"), LocalTime.parse("14:00")) instanceof CommonEventItem);
    }

    @Test
    void Task_create_test_example_2() {
        assertNotNull(test_example_2.create("watching TV",LocalDate.of(2021, 6, 18),
                LocalDate.of(2021, 6, 18), LocalTime.parse("16:00"), LocalTime.parse("18:00")));
        assertTrue(test_example_2.create("watching TV", LocalDate.of(2021, 6, 18),
                LocalDate.of(2021, 6, 18), LocalTime.parse("16:00"), LocalTime.parse("18:00"))
                        instanceof CommonEventItem);
    }

}