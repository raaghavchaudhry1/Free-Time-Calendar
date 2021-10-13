import jdk.jfr.Event;

import java.util.*;

/**
 * Calculates the free-times for a group of students
 */
public class FreeTimeCalculator {

    /**
     * Calculates the free-times of a group of students
     * @param stuManager The StudentManager containing all created Students
     * @return the Calendar containing all free-times of a week
     */
    public Calendar getFreeCalendar(StudentManager stuManager){
        Map<String, List<Event>> aggregateRoutine = getAggregateRoutine(stuManager);
        return calculateFreeTime(aggregateRoutine);
    }

    /**
     * NOTDONE
     * Calculates the free-times of a given aggregateRoutine and returns the Calendar for the free-times
     * @param aggregateRoutine
     * @return
     */
    public Calendar calculateFreeTime(Map<String, List<Event>> aggregateRoutine){
        Calendar freeCalendar = new Calendar();
        for(Map.Entry<String, List<Event>> entry : aggregateRoutine.entrySet()) {
            String day = entry.getKey();
            List daySchedule = entry.getValue();

            //calculate freetime of the day in the loop and do something with it
        }
        return freeCalendar;
    }

    /**
     * Calculates the aggregate routines of the students in a StudentManager
     * @param stuManager the StudentManager that stores all the students
     * @return the aggregate routines of the students in StudentManager
     */
    public Map getAggregateRoutine(StudentManager stuManager){
        Map<String, Calendar> calendars  = stuManager.getCalendars(); //assuming stuManager has a get all calendars method
        Map<String, List<Event>> aggregateRoutine= new HashMap<String, List<Event>>();
        calendars.forEach((username, calendar) -> {
            calendar.getRecurring().forEach((day, events) -> getUnionEvent(aggregateRoutine.get(day), events));
        });
        return aggregateRoutine;
    }

    /**
     * Calculates the union of two lists
     * @param list1 one of the list to calculate union of
     * @param list2 the other list to calculate the union of
     * @return the union of the two Lists as an ArrayList
     */
    private static List<Event> getUnionEvent(List<Event> list1, List<Event> list2) {

        Set<Event> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<Event>(set);
    }
}
