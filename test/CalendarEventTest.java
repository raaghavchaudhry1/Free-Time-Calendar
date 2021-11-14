import org.junit.*;

import static org.junit.Assert.*;

public class CalendarEventTest {
    CalendarEvent event;

    @Before
    public void setUp() {
        event = new CalendarEvent("Lecture", 3.0f, 4.0f, "Tuesday");
    }

    @Test(timeout = 50)
    public void TestGetDay() {
        assertEquals("Tuesday", event.getDayOrDate());
    }

    @Test(timeout = 50)
    public void TestGetDuration() {
        assertEquals(1.0f, event.getDuration(), 0);
    }

    @Test(timeout = 50)
    public void TestCompareTo() {
        CalendarEvent tut = new CalendarEvent("Tutorial", 2.0f, 5.0f, "Wednesday");
        assertEquals(1, event.compareTo(tut));
    }

}
