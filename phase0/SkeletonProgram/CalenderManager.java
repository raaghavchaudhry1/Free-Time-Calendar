
public class CalendarManager {

    public CalendarManager() {
    }

    public void addRecurringEvents(Student student, ArrayList<CalendarEvent> events) {
        for (CalendarEvent event: events) {
//            Wrote with the assumption that recurring events have a day attribute and a getDay method to retrieve said attribute
            String day = event.getDay();
            student.calendar.addRecurEvent(day, event);
        }

    }

    public void addSingleEvents(Student student, ArrayList<CalendarEvent> events) {
        for (CalendarEvent event: events) {
            student.calendar.addSingleEvent(event.getDate(), event);
        }
    }

    public void removeRecurringEvents(Student student, ArrayList<CalendarEvent> events) {
        for (CalendarEvent event: events) {
            student.calendar.removeRecurEvent(event.getDay(), event);
        }
    }

    public void removeSingleEvents(Student student, ArrayList<CalendarEvent> events) {
        for (CalendarEvent event: events) {
            student.calendar.removeSingelEvent(event.getDate(), event);
        }
    }

}