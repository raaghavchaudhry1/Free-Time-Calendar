import java.util.ArrayList;

public class CalendarController {

    private CalendarManager calendarManager;
    private EventCreator eventCreator;

    public void addRecEvent(Student student, ArrayList<CalendarEvent> events) {
        calendarManager.addRecurringEvents(student, events);
    }

    public void addOneOffEvent(Student student, ArrayList<OneOffEvent> events) {
        calendarManager.addSingleEvents(student, events);
    }

    public CalendarEvent createRecEvent(String name, float start, float end, String day) {
        eventCreator.createEvent(name, start, end, day);
    }

    public CalendarEvent createRecEvent(String name, float start, float end, float date) {
        eventCreator.createEvent(name, start, end, date);
    }

}
