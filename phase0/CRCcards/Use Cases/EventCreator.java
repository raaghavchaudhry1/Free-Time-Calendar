public class EventCreator {
    public CalendarEvent createEvent(String name, float start, float end) {
        // if recurring and not given a date
        return CalendarEvent(name, start, end);
    }

    public CalendarEvent createEvent(String name, float start, float end, float date) {
        // if not recurring
        return (CalendarEvent) OneOffEvent(name, start, end, date);
    }
}