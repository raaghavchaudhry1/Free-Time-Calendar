import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StudentManager {

    private HashMap<String, Student> students;

    public StudentManager() {
        this.students = new HashMap<String, Student>();
    }

    public StudentManager(HashMap<String, Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.put(student.getUsername(), student);
    }

    public HashMap<String, Student> getAllStudents() {
        return students;
    }

    public void setAllStudents(HashMap<String, Student> students) {
        this.students = students;
    }

    public Set<String> getAllStudentUsers() { return this.students.keySet(); }

    public void addNewStudent(String username, String password){
        students.put(username, new Student(username, password));
    }

    public boolean checkValidStudent(Student student) {
        // returns true if student is already within hashmap, false otherwise
        String user = student.getUsername();
        return this.students.containsKey(user);
    }

    public HashMap<String, ArrayList<CalendarEvent>> getCalendarRecurring(String username) {

        if (students.containsKey(username)) {

            Student curr  = students.get(username);
            Calendar studentScehdule = curr.getStudentSchedule();
            return  studentScehdule.getRecurring();



        } else {

            return null;
        }


    }

    public HashMap<Float, ArrayList<OneOffEvent>> getCalendarOneOff(String username) {

        if (students.containsKey(username)) {

            Student curr  = students.get(username);
            Calendar studentScehdule = curr.getStudentSchedule();
            return  studentScehdule.getSingle();

        } else {

            return null;
        }


    }


    public  ArrayList<ArrayList<Object>> getTimes(String username, Float date, String day) {

        if (students.containsKey(username)) {

            Student curr  = students.get(username);
            Calendar studentScehdule = curr.getStudentSchedule();
            ArrayList<OneOffEvent> oneOffs = studentScehdule.getSingle().get(date);
            ArrayList<CalendarEvent> calendarEvents = studentScehdule.getRecurring().get(day);
            int length1 = oneOffs.size();
            int length2 = calendarEvents.size();
            ArrayList<ArrayList<Object>> eventTimes = new ArrayList<>();

            for (int i = 0; i < length1; i++) {
                ArrayList<Object> temp = new ArrayList<>();
                temp.add(oneOffs.get(i).getStartTime());
                temp.add(oneOffs.get(i).getEndTime());
                temp.add(oneOffs.get(i).getName());
                eventTimes.add(temp);
            }
            for (int i = 0; i < length2; i++) {
                ArrayList<Object> temp = new ArrayList<>();
                temp.add(calendarEvents.get(i).getStartTime());
                temp.add(calendarEvents.get(i).getEndTime());
                temp.add(calendarEvents.get(i).getName());
                eventTimes.add(temp);
            }
            return eventTimes;

        } else {

            return null;
        }


    }





}
