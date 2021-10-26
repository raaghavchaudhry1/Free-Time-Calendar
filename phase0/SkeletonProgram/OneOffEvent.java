public class OneOffEvent implements EventInterface {
    private String name;
    private float start;     // hour.minute
    private float end;
    private float duration;     // end - start
    private float date;     // month and day of the year in format mm.dd

    public OneOffEvent(String name, float start, float end, float date) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.duration = end - start;
        this.date = date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float getStartTime() {
        return start;
    }

    @Override
    public void setStartTime(float start) {
        this.start = start;
    }

    @Override
    public float getEndTime() {
        return end;
    }

    @Override
    public void setEndTime(float end) {
        this.end = end;
    }

    @Override
    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public String getDayOrDate() {
        return Float.toString(date);
    }

    @Override
    public void setDayOrDate(String date) {
        this.date = Float.parseFloat(date);
    }
}