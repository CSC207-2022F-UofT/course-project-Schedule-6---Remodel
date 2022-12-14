package responseModel.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EventItemResponseModelTest{

    @BeforeEach
    void setUp() {
    }
    EventItemResponseModel test_event = new EventItemResponseModel("Finish testcases", LocalDate.now(),
            LocalDate.now().plusDays(1), LocalTime.now(),  LocalTime.now().plusHours(1));

    @Test
    void Event_Test_GetTitle(){
        assertNotNull(test_event.getTitle());
        assertTrue(test_event.getTitle().equals("Finish testcases"));
    }

    @Test
    void Event_Test_GetStartDate(){
        assertNotNull(test_event.getStartDate());
        assertTrue(test_event.getStartDate() == LocalDate.now());
    }

    @Test
    void Event_Test_GetEndDate(){
        assertNotNull(test_event.getEndDate());
        assertTrue(test_event.getEndDate() == LocalDate.now().plusDays(1));
    }

    @Test
    void Event_Test_GetStartTime(){
        assertNotNull(test_event.getStartTime());
        assertTrue(test_event.getStartTime() == LocalTime.now());
    }

    @Test
    void Event_Test_GetEndTime(){
        assertNotNull(test_event.getEndTime());
        assertTrue(test_event.getEndTime() == LocalTime.now().plusHours(1));
    }
}
