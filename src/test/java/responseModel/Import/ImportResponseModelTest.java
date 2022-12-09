package responseModel.Import;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImportResponseModelTest{

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<LocalDate> startDates = new ArrayList<>();
    ArrayList<LocalDate> endDates = new ArrayList<>();
    ArrayList<LocalTime> startTimes = new ArrayList<>();
    ArrayList<LocalTime> endTimes = new ArrayList<>();
    ArrayList<String> rr = new ArrayList<>();
    @BeforeEach
    void setUp() {
        titles.add("1");
        titles.add("2");
        titles.add("3");
        startDates.add(LocalDate.now());
        startDates.add(LocalDate.now().plusDays(1));
        startDates.add(LocalDate.now().plusDays(2));
        endDates.add(LocalDate.now());
        endDates.add(LocalDate.now().plusDays(2));
        endDates.add(LocalDate.now().plusDays(2));
        startTimes.add(LocalTime.now());
        startTimes.add(LocalTime.now().plusHours(1));
        startTimes.add(LocalTime.now().plusHours(3));
        endTimes.add(LocalTime.now().plusHours(1));
        endTimes.add(LocalTime.now().plusHours(2));
        endTimes.add(LocalTime.now().plusHours(4));


    }
    ImportResponseModel test_import = new ImportResponseModel(titles, startDates, endDates, startTimes, endTimes, rr);

    @Test
    void Import_Test_GetTitles(){
        assertNotNull(test_import.getTitles());
        assertTrue(test_import.getTitles() == titles);
    }

    @Test
    void Import_Test_GetStartDate(){
        assertNotNull(test_import.getStartDates());
        assertTrue(test_import.getStartDates() == startDates);
    }

    @Test
    void Import_Test_GetEndDate(){
        assertNotNull(test_import.getEndDates());
        assertTrue(test_import.getEndDates() == endDates);
    }

    @Test
    void Import_Test_GetStartTimes(){
        assertNotNull(test_import.getStartTimes());
        assertTrue(test_import.getStartTimes() == startTimes);
    }

    @Test
    void Import_Test_GetEndTimes(){
        assertNotNull(test_import.getEndTimes());
        assertTrue(test_import.getEndTimes() == endTimes);
    }

    @Test
    void Import_Test_getRRules(){
        assertNotNull(test_import.getRRules());
        assertTrue(test_import.getRRules() == rr);
    }
}
