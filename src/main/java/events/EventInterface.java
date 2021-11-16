package events;

public interface EventInterface extends Comparable<EventInterface>{
    public String getName();

    public float getStartTime();

    public float getEndTime();

    public float getDuration();

    public String getDayOrDate();

    public void setName(String name);

    public void setStartTime(float time);

    public void setEndTime(float time);

    public void setDayOrDate(String dayOrDate);
}
