public class EventCreator {
    private final CalendarEvent event;

    public EventCreator(String name, float start, float end) {
        // if recurring and not given a date
        this.event = CalendarEvent(name, start, end);
    }

    public EventCreator(String name, float start, float end, float date) {
        // if not recurring
        this.event = (CalendarEvent) OneOffEvent(name, start, end, date);
    }

    public CalendarEvent createEvent() {
        return this.event;
    }

}