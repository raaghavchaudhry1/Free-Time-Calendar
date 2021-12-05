package users.students;

import calendar.Calendar;
import events.CalendarEvent;
import events.OneOffEvent;
import backend.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StudentManager {

    private HashMap<String, StudentBuilder> students;

    public StudentManager() {
        this.students = new HashMap<String, StudentBuilder>();
    }

    public StudentManager(HashMap<String, StudentBuilder> students) {
        this.students = students;
    }

    public void addStudent(StudentBuilder studentBuilder) {
        this.students.put(studentBuilder.getUsername(), studentBuilder);
    }

    public HashMap<String, StudentBuilder> getAllStudents() {
        return students;
    }

    public void setAllStudents(HashMap<String, StudentBuilder> students) {
        this.students = students;
    }

    public Set<String> getAllStudentUsers() { return this.students.keySet(); }

    public void addNewStudent(String username, String password){
        students.put(username, new StudentBuilder(username, password));
    }

    public void addTask(String user, Task task) {
        this.students.get(user).getTaskList().addTask(task);

    }

    public void removeTask(String user, Task task) {
        this.students.get(user).getTaskList().removeTask(task);
    }

    public void closeTask(String user, Task task) {
        this.students.get(user).getTaskList().closeTask(task);
    }


    public boolean checkValidStudent(StudentBuilder studentBuilder) {
        // returns true if student is already within hashmap, false otherwise
        String user = studentBuilder.getUsername();
        return this.students.containsKey(user);
    }

    public HashMap<String, ArrayList<CalendarEvent>> getCalendarRecurring(String username) {

        if (students.containsKey(username)) {

            StudentBuilder curr  = students.get(username);
            Calendar studentScehdule = curr.getStudentSchedule();
            return  studentScehdule.getRecurring();

        } else {
            return new HashMap<String, ArrayList<CalendarEvent>>();
        }
    }

    public HashMap<Float, ArrayList<OneOffEvent>> getCalendarOneOff(String username) {

        if (students.containsKey(username)) {

            StudentBuilder curr = students.get(username);
            Calendar studentScehdule = curr.getStudentSchedule();
            return studentScehdule.getSingle();
        } else {
            return new HashMap<Float, ArrayList<OneOffEvent>>();
        }
    }


    public ArrayList<ArrayList<Object>> getTimes(String username, Float date, String day) {

        if (students.containsKey(username)) {

            StudentBuilder curr = students.get(username);
            Calendar studentScehdule = curr.getStudentSchedule();

            ArrayList<ArrayList<Object>> eventTimes = new ArrayList<>();
            ArrayList<CalendarEvent> calendarEvents = studentScehdule.getRecurring().get(day);

            if (studentScehdule.getSingle().containsKey(date)) {
                ArrayList<OneOffEvent> oneOffs = studentScehdule.getSingle().get(date);
                int length1 = oneOffs.size();

                for (int i = 0; i < length1; i++) {
                    ArrayList<Object> temp = new ArrayList<>();
                    temp.add(oneOffs.get(i).getStartTime());
                    temp.add(oneOffs.get(i).getEndTime());
                    temp.add(oneOffs.get(i).getName());
                    eventTimes.add(temp);
                }
            }

            int length2 = calendarEvents.size();

            for (int i = 0; i < length2; i++) {
                ArrayList<Object> temp = new ArrayList<>();
                temp.add(calendarEvents.get(i).getStartTime());
                temp.add(calendarEvents.get(i).getEndTime());
                temp.add(calendarEvents.get(i).getName());
                eventTimes.add(temp);
            }
            return eventTimes;

        } else {

            return new ArrayList<ArrayList<Object>>();
        }


    }

}
