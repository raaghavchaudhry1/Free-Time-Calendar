import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class Calendar {
    private HashMap<String, ArrayList<CalendarEvent>> recurring;
    private HashMap<LocalDate, ArrayList<CalendarEvent>> single;

    public Calendar() {
        this.recurring = new HashMap<>();
        this.recurring.put("Monday", new ArrayList<>());
        this.recurring.put("Tuesday", new ArrayList<>());
        this.recurring.put("Wednesday", new ArrayList<>());
        this.recurring.put("Thursday", new ArrayList<>());
        this.recurring.put("Friday", new ArrayList<>());
        this.recurring.put("Saturday", new ArrayList<>());
        this.recurring.put("Sunday", new ArrayList<>());

        this.single = new HashMap<>();

    }

    public void addRecurEvent(String day, CalendarEvent event) {
        this.recurring.get(day).add(event);
    }

    public void addSingleEvent(LocalDate date, CalendarEvent event) {
        if (this.single.containsKey(date)) {
            this.single.get(date).add(event);
        } else {
            ArrayList<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
            eventList.add(event);
            this.single.put(date, eventList);
        }
    }

    public void removeRecurEvent(String day, CalendarEvent event) {
        this.recurring.get(day).remove(event);
    }

    public void removeSingleEvent(LocalDate date, CalendarEvent event) {
        this.single.get(date).remove(event);
    }

    public HashMap<String, ArrayList<CalendarEvent>> getRecurring() {
        return this.recurring;
    }

    public HashMap<LocalDate, ArrayList<CalendarEvent>> getSingle() {
        return this.single;
    }


}
