package calendar;

import events.CalendarEvent;
import events.OneOffEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

public class Calendar implements Serializable {
    private HashMap<String, ArrayList<CalendarEvent>> recurring;
    private HashMap<Float, ArrayList<OneOffEvent>> single;

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

    public void addSingleEvent(float date, OneOffEvent event) {
        if (this.single.containsKey(date)) {
            this.single.get(date).add(event);
        } else {
            ArrayList<OneOffEvent> eventList = new ArrayList<OneOffEvent>();
            eventList.add(event);
            this.single.put(date, eventList);
        }
    }

    public void removeRecurEvent(String day, CalendarEvent event) {
        this.recurring.get(day).remove(event);
    }

    public void removeSingleEvent(float date, OneOffEvent event) {
        this.single.get(date).remove(event);
    }

    public HashMap<String, ArrayList<CalendarEvent>> getRecurring() {
        return this.recurring;
    }

    public HashMap<Float, ArrayList<OneOffEvent>> getSingle() {
        return this.single;
    }


}
