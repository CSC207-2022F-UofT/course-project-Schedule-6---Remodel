package java.responseModel.Event;

import main.java.responseModel.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImportResponseModelTest{

    @BeforeEach
    void setUp() {
    }
    ImportResponseModel test_import = new ImportResponseModel(["1","2","3"], [LocalDate.now(), LocalDate.now().plusDays(1),
    LocalDate.now().plusDays(2)], [LocalDate.now(), LocalDate.now().plusDays(2),
    LocalDate.now().plusDays(2)], [LocalTime.now(), LocalTime.now().plusHours(1), LocalTime.now().plusHours(3)],
            [LocalTime.now().plusHours(1), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4)],
            []);

    @Test
    void Import_Test_GetTitles(){
        assertNotNull(test_import.getTitles());
        assertTrue(test_import.getTitles() == ["1","2","3"]);
    }

    @Test
    void Import_Test_GetStartDate(){
        assertNotNull(test_import.getStartDates());
        assertTrue(test_import.getStartDates() == [LocalDate.now(), LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2)]);
    }

    @Test
    void Import_Test_GetEndDate(){
        assertNotNull(test_import.getEndDates());
        assertTrue(test_import.getEndDates() == [LocalDate.now(), LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(2)]);
    }

    @Test
    void Import_Test_GetStartTimes(){
        assertNotNull(test_import.getStartTimes());
        assertTrue(test_import.getStartTimes() == [LocalTime.now(), LocalTime.now().plusHours(1), LocalTime.now().plusHours(3)]);
    }

    @Test
    void Import_Test_GetEndTimes(){
        assertNotNull(test_import.getEndTimes());
        assertTrue(test_import.getEndTimes() == [LocalTime.now().plusHours(1), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4)]);
    }

    @Test
    void Import_Test_getRRules(){
        assertNotNull(test_import.getRRules());
        asserTrue(test_import.getRRules() == []);
    }
}
