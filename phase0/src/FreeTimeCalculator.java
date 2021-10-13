import java.util.*;

/**
 * Calculates the free-times for a group of students
 */
public class FreeTimeCalculator {
    private static final int HOUR = 60;

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
     * Calculates the free-times of a given aggregateRoutine and returns the Calendar for the free-times
     * @param aggregateRoutine
     * @return the free-time Calendar
     */
    private Calendar calculateFreeTime(Map<String, List<Event>> aggregateRoutine){
        Calendar freeCalendar = new Calendar();
        //for each day in aggregateRoutine, calculate freeTime
        for(Map.Entry<String, List<Event>> entry : aggregateRoutine.entrySet()) {
            String day = entry.getKey();
            List<> daySchedule = entry.getValue();

            //calculate every day's free time as an ArrayList
            Collections.sort(daySchedule); //need compareTo method from Comparable Interface
            ArrayList<Event> dayFreeTime = getDayFreeTime(day, daySchedule);

            //Convert ArrayList to a value in the Calendar
            for (Event event : dayFreeTime){
                freeCalendar.addRecurEvent(day, event);
            }
        }
        return freeCalendar;
    }

    /**
     * Calculate the free-times of a day
     * @param day
     * @param daySchedule
     * @return an ArrayList containing
     */
    private ArrayList<Event> getDayFreeTime(String day, List<Event> daySchedule) {
        ArrayList<Event> dayFreeTime= new ArrayList<Event>();
        EventCreator eventC = new EventCreator();
        dayFreeTime.add(eventC.createEvent("Free", 0, 23.59));

        for (Event event: daySchedule){
            float startTime = event.getStartTime();
            float endTime = event.getEndTime();

            List<Event> toRemove = new ArrayList<>();
            RemoveAndAdd(dayFreeTime, startTime, endTime, toRemove);
            remove(dayFreeTime, toRemove);
            Collections.sort(dayFreeTime);
        }
        return dayFreeTime;
    }

    /**
     * Remove each event in toRemove from dayFreeTime
     * @param dayFreeTime
     * @param toRemove
     */
    private void remove(ArrayList<Event> dayFreeTime, List<Event> toRemove) {
        for (Event toRemEvent: toRemove){
            dayFreeTime.remove(toRemEvent);
        }
    }

    /**
     *
     * @param dayFreeTime
     * @param startTime
     * @param endTime
     * @param toRemove
     */
    private void RemoveAndAdd(ArrayList<Event> dayFreeTime,
                              float startTime, float endTime, List<Event> toRemove) {
        for (int i = 0; i < dayFreeTime.size(); i++) {
            EventCreator eventC = new EventCreator();
            Event eventToCheck = dayFreeTime.get(i);
            float startFree = eventToCheck.getStartTime();
            float endFree = eventToCheck.getEndTime();

            //haha the funny
            if (startTime < endFree || endTime > startFree) {
                toRemove.add(eventToCheck);
                if (startTime >= startFree && endTime <= endFree) {
                    eventC.createEvent("", startFree, startTime);
                    eventC.createEvent("", endTime, endFree);
                } else if (startTime >= startFree && endTime >= endFree) {
                    eventC.createEvent("", startFree, startTime);
                } else if (startTime <= startFree && endTime <= endFree) {
                    eventC.createEvent("", endTime, endFree);
                } else if (startTime <= startFree && endTime >= endFree) {
                    eventC.createEvent("", endTime, endFree);
                }
            }
        }
    }


    /**
     * Calculates the aggregate routines of the students in a StudentManager
     * @param stuManager the StudentManager that stores all the students
     * @return the aggregate routines of the students in StudentManager
     */
    private Map getAggregateRoutine(StudentManager stuManager){
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
