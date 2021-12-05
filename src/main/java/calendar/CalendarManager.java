package calendar;

import events.CalendarEvent;
import events.OneOffEvent;
import users.students.StudentBuilder;

import java.util.ArrayList;

public class CalendarManager {


    public void addRecurringEvents(StudentBuilder studentBuilder, ArrayList<CalendarEvent> events) {

        for (CalendarEvent event: events) {
//            Wrote with the assumption that recurring events have a day attribute and a getDay method to retrieve said attribute
            String day = event.getDayOrDate();
            studentBuilder.getStudentSchedule().addRecurEvent(day, event);
        }

    }

    public void addSingleEvents(StudentBuilder studentBuilder, ArrayList<OneOffEvent> events) {
        for (OneOffEvent event: events) {
            studentBuilder.getStudentSchedule().addSingleEvent(Float.parseFloat(event.getDayOrDate()), event);
        }
    }

    public void removeRecurringEvents(StudentBuilder studentBuilder, ArrayList<CalendarEvent> events) {
        for (CalendarEvent event: events) {
            studentBuilder.getStudentSchedule().removeRecurEvent(event.getDayOrDate(), event);
        }
    }

    public void removeSingleEvents(StudentBuilder studentBuilder, ArrayList<OneOffEvent> events) {
        for (OneOffEvent event: events) {
            studentBuilder.getStudentSchedule().removeSingleEvent(Float.parseFloat(event.getDayOrDate()), event);
        }
    }

}