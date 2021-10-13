import jdk.jfr.Event; //placeholder

import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Contains data for weekly recurring events and single events
 */

public class Calendar {
    private HashMap<String, ArrayList<Event>> recurring;
    private HashMap<LocalDate, Event> single;

    /**
     * Initializes all days of the week
     */
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

    /**
     * Add a recurring event to recurring on the given day
     * @param day the day of the week
     * @param event the event to add to the day of the week
     */
    public void addRecurEvent(String day, Event event) {
        this.recurring.get(day).add(event);
    }

    /**
     * Add a single event to single for the given date
     * @param date the date of the event
     * @param event the event to add to single
     */
    public void addSingleEvent(LocalDate date, Event event) {
        this.single.put(date, event);
    }

    public HashMap<String, ArrayList<Event>> getRecurring() {
        return this.recurring;
    }

    public HashMap<LocalDate, Event> getSingle() {
        return this.single;
    }


}