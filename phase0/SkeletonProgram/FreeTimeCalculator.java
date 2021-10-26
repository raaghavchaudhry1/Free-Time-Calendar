import java.util.*;

/**
 * Calculates the free-times for a group of students
 */
public class FreeTimeCalculator {
    /**
     * Calculates the free-times of a group of students
     * @param groupManager The GroupManager containing all created Students
     * @return the Calendar containing all free-times of a week
     */
    public Calendar getFreeCalendar(GroupManager groupManager, String groupID){
        Group group = groupManager.getGroup(groupID);
        Map<String, List<CalendarEvent>> aggregateRoutine = getAggregateRoutine(group);
        return calculateFreeTime(aggregateRoutine);
    }

    /**
     * Calculates the free-times of a given aggregateRoutine and returns the Calendar for the free-times
     * @param aggregateRoutine
     * @return the free-time Calendar
     */
    private Calendar calculateFreeTime(Map<String, List<CalendarEvent>> aggregateRoutine){
        Calendar freeCalendar = new Calendar();
        //for each day in aggregateRoutine, calculate freeTime
        for(Map.Entry<String, List<CalendarEvent>> entry : aggregateRoutine.entrySet()) {
            String day = entry.getKey();
            List<CalendarEvent> daySchedule = entry.getValue();

            //calculate every day's free time as an ArrayList
            Collections.sort(daySchedule); //need compareTo method from Comparable Interface
            ArrayList<CalendarEvent> dayFreeTime = getDayFreeTime(day, daySchedule);

            //Convert ArrayList to a value in the Calendar
            for (CalendarEvent event : dayFreeTime){
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
    private ArrayList<CalendarEvent> getDayFreeTime(String day, List<CalendarEvent> daySchedule) {
        ArrayList<CalendarEvent> dayFreeTime= new ArrayList<CalendarEvent>();
        EventCreator eventC = new EventCreator();
        dayFreeTime.add(eventC.createEvent("Free", 0, (float) 23.59, day));

        for (CalendarEvent event: daySchedule){
            float startTime = event.getStartTime();
            float endTime = event.getEndTime();

            List<CalendarEvent> toRemove = new ArrayList<>();
            List<CalendarEvent> toAdd = addToRemoveAndAdd(dayFreeTime, startTime, endTime, toRemove, day);
            removeAndAdd(dayFreeTime, toRemove, toAdd);
            Collections.sort(dayFreeTime);
        }
        return dayFreeTime;
    }

    /**
     * Remove each event in toRemove from dayFreeTime
     * @param dayFreeTime
     * @param toRemove
     */
    private void removeAndAdd(ArrayList<CalendarEvent> dayFreeTime, List<CalendarEvent> toRemove,
                              List<CalendarEvent> toAdd) {
        for (CalendarEvent toRemEvent: toRemove){
            dayFreeTime.remove(toRemEvent);
        }
        for (CalendarEvent toAddEvent: toAdd){
            dayFreeTime.add(toAddEvent);
        }
    }


    /**
     * @param dayFreeTime
     * @param startTime
     * @param endTime
     * @param toRemove
     * @param day
     * @return
     */
    private List<CalendarEvent> addToRemoveAndAdd(ArrayList<CalendarEvent> dayFreeTime,
                                             float startTime, float endTime, List<CalendarEvent> toRemove, String day) {
        List<CalendarEvent> toAdd = new ArrayList<>();
        for (int i = 0; i < dayFreeTime.size(); i++) {
            EventCreator eventC = new EventCreator();
            CalendarEvent eventToCheck = dayFreeTime.get(i);
            float startFree = eventToCheck.getStartTime();
            float endFree = eventToCheck.getEndTime();


            if (startTime >= startFree && endTime <= endFree) {
                toRemove.add(eventToCheck);
                if (startTime != startFree){
                    toAdd.add(eventC.createEvent("", startFree, startTime, day));
                }
                if (endTime != endFree) {
                    toAdd.add(eventC.createEvent("", endTime, endFree, day));
                }
            } else if (startTime >= startFree && endTime >= endFree && startTime <= endFree) {
                toRemove.add(eventToCheck);
                toAdd.add(eventC.createEvent("", startFree, startTime, day));
            } else if (startTime <= startFree && endTime <= endFree && endTime >= startFree)  {
                toRemove.add(eventToCheck);
                toAdd.add(eventC.createEvent("", endTime, endFree, day));
            }

        }

        return toAdd;
    }


    /**
     * Calculates the aggregate routines of the students in a StudentManager
     * @param group the StudentManager that stores all the students
     * @return the aggregate routines of the students in StudentManager
     */
    private Map getAggregateRoutine(Group group){
        ArrayList<Calendar> calendars  = group.getCalendars();//assuming group has a get all calendars method
        Map<String, List<CalendarEvent>> aggregateRoutine= new HashMap<String, List<CalendarEvent>>();
        createAggregateRoutine(aggregateRoutine);
        calendars.forEach((calendar) -> {
            calendar.getRecurring().forEach((day, events) -> aggregateRoutine.put(day,
                    getUnionEvent(aggregateRoutine.get(day), events)));
        });
        return aggregateRoutine;
    }

    private void createAggregateRoutine(Map<String, List<CalendarEvent>> aggregateRoutine) {
        aggregateRoutine.put("Monday", new ArrayList<>());
        aggregateRoutine.put("Tuesday", new ArrayList<>());
        aggregateRoutine.put("Wednesday", new ArrayList<>());
        aggregateRoutine.put("Thursday", new ArrayList<>());
        aggregateRoutine.put("Friday", new ArrayList<>());
        aggregateRoutine.put("Saturday", new ArrayList<>());
        aggregateRoutine.put("Sunday", new ArrayList<>());
    }

    /**
     * Calculates the union of two lists
     * @param list1 one of the list to calculate union of
     * @param list2 the other list to calculate the union of
     * @return the union of the two Lists as an ArrayList
     */
    private static List<CalendarEvent> getUnionEvent(List<CalendarEvent> list1, List<CalendarEvent> list2) {

        Set<CalendarEvent> set = new HashSet<CalendarEvent>();
        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<CalendarEvent>(set);
    }
}