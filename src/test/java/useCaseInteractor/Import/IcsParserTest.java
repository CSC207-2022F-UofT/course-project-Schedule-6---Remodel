package useCaseInteractor.Import;

import net.fortuna.ical4j.data.ParserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class IcsParserTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    void getFirstTitle() throws IOException, ParserException {
        FileInputStream f = new FileInputStream("/Users/tammywang/IdeaProjects/course-project-Schedule-6---Remodel/src/test/coursesCalendar.ics");
        IcsParser parser = new IcsParser(f);
        assertEquals(parser.getTitles().get(0), "COG250Y1 LEC0101");
    }

    @Test
    void getFirstStartDate() throws IOException, ParserException {
        FileInputStream f = new FileInputStream("/Users/tammywang/IdeaProjects/course-project-Schedule-6---Remodel/src/test/coursesCalendar.ics");
        IcsParser parser = new IcsParser(f);
        assertEquals(parser.getStartDates().get(0), "20220912T150000");
    }

    @Test
    void getFirstEndDate() throws IOException, ParserException {
        FileInputStream f = new FileInputStream("/Users/tammywang/IdeaProjects/course-project-Schedule-6---Remodel/src/test/coursesCalendar.ics");
        IcsParser parser = new IcsParser(f);
        assertEquals(parser.getEndDates().get(0), "20220912T180000");
    }

    @Test
    void getMiddleTitle() throws IOException, ParserException {
        FileInputStream f = new FileInputStream("/Users/tammywang/IdeaProjects/course-project-Schedule-6---Remodel/src/test/coursesCalendar.ics");
        IcsParser parser = new IcsParser(f);
        assertEquals(parser.getTitles().get(2), "CSC207H1 LEC5201");
    }

}