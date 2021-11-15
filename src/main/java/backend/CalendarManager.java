package backend;

import java.util.ArrayList;

public class CalendarManager {


    public void addRecurringEvents(Student student, ArrayList<CalendarEvent> events) {

        for (CalendarEvent event: events) {
//            Wrote with the assumption that recurring events have a day attribute and a getDay method to retrieve said attribute
            String day = event.getDayOrDate();
            student.getStudentSchedule().addRecurEvent(day, event);
        }

    }

    public void addSingleEvents(Student student, ArrayList<OneOffEvent> events) {
        for (OneOffEvent event: events) {
            student.getStudentSchedule().addSingleEvent(Float.parseFloat(event.getDayOrDate()), event);
        }
    }

    public void removeRecurringEvents(Student student, ArrayList<CalendarEvent> events) {
        for (CalendarEvent event: events) {
            student.getStudentSchedule().removeRecurEvent(event.getDayOrDate(), event);
        }
    }

    public void removeSingleEvents(Student student, ArrayList<OneOffEvent> events) {
        for (OneOffEvent event: events) {
            student.getStudentSchedule().removeSingleEvent(Float.parseFloat(event.getDayOrDate()), event);
        }
    }

}