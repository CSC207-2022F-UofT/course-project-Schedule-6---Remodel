<<<<<<< HEAD
package responseModel.Import;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
=======
package java.responseModel.Event;

import main.java.responseModel.*;
import org.junit.jupiter.api.BeforeAll;
>>>>>>> fed824d (Tests for responseModels)
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> fed824d (Tests for responseModels)

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImportResponseModelTest{

<<<<<<< HEAD
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
=======
    @BeforeEach
    void setUp() {
    }
    ImportResponseModel test_import = new ImportResponseModel(["1","2","3"], [LocalDate.now(), LocalDate.now().plusDays(1),
    LocalDate.now().plusDays(2)], [LocalDate.now(), LocalDate.now().plusDays(2),
    LocalDate.now().plusDays(2)], [LocalTime.now(), LocalTime.now().plusHours(1), LocalTime.now().plusHours(3)],
            [LocalTime.now().plusHours(1), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4)],
            []);
>>>>>>> fed824d (Tests for responseModels)

    @Test
    void Import_Test_GetTitles(){
        assertNotNull(test_import.getTitles());
<<<<<<< HEAD
        assertTrue(test_import.getTitles() == titles);
=======
        assertTrue(test_import.getTitles() == ["1","2","3"]);
>>>>>>> fed824d (Tests for responseModels)
    }

    @Test
    void Import_Test_GetStartDate(){
        assertNotNull(test_import.getStartDates());
<<<<<<< HEAD
        assertTrue(test_import.getStartDates() == startDates);
=======
        assertTrue(test_import.getStartDates() == [LocalDate.now(), LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2)]);
>>>>>>> fed824d (Tests for responseModels)
    }

    @Test
    void Import_Test_GetEndDate(){
        assertNotNull(test_import.getEndDates());
<<<<<<< HEAD
        assertTrue(test_import.getEndDates() == endDates);
=======
        assertTrue(test_import.getEndDates() == [LocalDate.now(), LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(2)]);
>>>>>>> fed824d (Tests for responseModels)
    }

    @Test
    void Import_Test_GetStartTimes(){
        assertNotNull(test_import.getStartTimes());
<<<<<<< HEAD
        assertTrue(test_import.getStartTimes() == startTimes);
=======
        assertTrue(test_import.getStartTimes() == [LocalTime.now(), LocalTime.now().plusHours(1), LocalTime.now().plusHours(3)]);
>>>>>>> fed824d (Tests for responseModels)
    }

    @Test
    void Import_Test_GetEndTimes(){
        assertNotNull(test_import.getEndTimes());
<<<<<<< HEAD
        assertTrue(test_import.getEndTimes() == endTimes);
=======
        assertTrue(test_import.getEndTimes() == [LocalTime.now().plusHours(1), LocalTime.now().plusHours(2), LocalTime.now().plusHours(4)]);
>>>>>>> fed824d (Tests for responseModels)
    }

    @Test
    void Import_Test_getRRules(){
        assertNotNull(test_import.getRRules());
<<<<<<< HEAD
        assertTrue(test_import.getRRules() == rr);
=======
        asserTrue(test_import.getRRules() == []);
>>>>>>> fed824d (Tests for responseModels)
    }
}
