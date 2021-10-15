import org.junit.*;

import static org.junit.Assert.*;

public class CalendarEventTest {
    CalendarEvent lec;
    CalendarEvent tut;

    @Before
    public void setUp() {
        lec = new CalendarEvent("Lecture", 3.0f, 4.0f, "Tuesday");
        tut = new CalendarEvent("Tutorial", 2.0f, 5.0f, "Wednesday");;
    }

    @Test(timeout = 50)
    public void TestGetDuration() {
        assertEquals(1.0, lec.getDuration());
    }

    @Test(timeout = 50)
    public void TestCompareTo() {
        assertEquals(1, lec.compareTo(tut));
    }

}
