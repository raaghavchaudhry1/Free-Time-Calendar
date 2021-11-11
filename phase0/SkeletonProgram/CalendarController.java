import java.util.ArrayList;

public class CalendarController {

    private CalendarManager calendarManager;
    private EventCreator eventCreator;

    public CalendarController() {
        this.calendarManager = new CalendarManager();
        this.eventCreator = new EventCreator();
    }
    public void addRecEvent(Student student, ArrayList<CalendarEvent> events) {
        calendarManager.addRecurringEvents(student, events);
    }

    public void addOneOffEvent(Student student, ArrayList<OneOffEvent> events) {
        calendarManager.addSingleEvents(student, events);
    }

    public EventInterface createRecEvent(String name, float start, float end, String day) {
        return eventCreator.createEvent(name, start, end, day);
    }

    public EventInterface createOneOffEvent(String name, float start, float end, float date) {
        return eventCreator.createEvent(name, start, end, date);
    }

}
