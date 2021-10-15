// import java.util.Date;

public class CalendarEvent {
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

    public String getName() {
        return this.name;
    }

    public float getStartTime() {
        return this.start;
    }

    public float getEndTime() {
        return this.end;
    }

    public float getDuration() {
        return this.duration;
    }

    public String getDay() { return this.day; }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(float time) {
        this.start = time;
        this.duration = getEndTime() - time;
    }

    public void setEndTime(float time) {
        this.end = time;
        this.duration = time - getStartTime();
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int compareTo(CalendarEvent other) {
        /* Compares 2 events based on their start times
        Returns -1 if current event starts earlier than other event
                1 if current event starts later than other event
                0 if 2 events have the same start time */
        return Float.compare(this.start, other.start);
    }

}