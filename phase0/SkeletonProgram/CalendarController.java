import java.util.ArrayList;
import java.util.HashMap;

public class CalendarController {
    private CalendarManager calendarManager;
    private EventCreator eventCreator;
    private StudentController studentController;

    public CalendarController(StudentController studentController) {
        this.calendarManager = new CalendarManager();
        this.eventCreator = new EventCreator();
        this.studentController = studentController;
    }
    public void addRecEvent(String student, ArrayList<CalendarEvent> events) {
        calendarManager.addRecurringEvents(this.getStudent(student), events);
    }

    public void addOneOffEvent(String student, ArrayList<OneOffEvent> events) {
        calendarManager.addSingleEvents(this.getStudent(student), events);
    }

    public CalendarEvent createRecEvent(String name, float start, float end, String day) {
        return eventCreator.createEvent(name, start, end, day);
    }

    public OneOffEvent createOneOffEvent(String name, float start, float end, float date) {
        return eventCreator.createEvent(name, start, end, date);
    }

    public Student getStudent(String student){
        HashMap<String, Student> students = this.studentController.getAllStudents();
        return students.get(student);
    }


}
