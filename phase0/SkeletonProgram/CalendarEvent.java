// import java.util.Date;

public class CalendarEvent {    // error message - missing package statement
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

    public String getDay() { return this.day;}

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

    public void setDay(String day){
        this.day = day;
    }

}