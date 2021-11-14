// import java.util.Date;

import java.util.WeakHashMap;

public class CalendarEvent implements EventInterface{
    private String name;
    private float start;     // hour.minute
    private float end;
    private float duration;     // end - start
    private String day;     // day of the week

    public CalendarEvent(String name, float start, float end, String day) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.duration = end - start;
        this.day = day;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getStartTime() {
        return this.start;
    }

    @Override
    public float getEndTime() {
        return this.end;
    }

    @Override
    public float getDuration() {
        return this.duration;
    }

    @Override
    public String getDayOrDate() { return this.day; }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setStartTime(float time) {
        this.start = time;
        this.duration = getEndTime() - time;
    }

    @Override
    public void setEndTime(float time) {
        this.end = time;
        this.duration = time - getStartTime();
    }

    @Override
    public void setDayOrDate(String day) {
        this.day = day;
    }

    @Override
    public int compareTo(EventInterface other) {
        /* Compares 2 events based on their start times
        Returns -1 if current event starts earlier than other event
                1 if current event starts later than other event
                0 if 2 events have the same start time */
        return Float.compare(this.start, other.getStartTime());
    }
}