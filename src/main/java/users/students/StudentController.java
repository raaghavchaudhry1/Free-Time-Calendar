package users.students;

import events.CalendarEvent;
import events.OneOffEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentController {

    private StudentManager studentManager;

    public StudentController(){
        this.studentManager = new StudentManager();
    }

    public boolean addStudent(StudentBuilder studentBuilder) {
        // returns true if student has been added to hashmap, false if student already exists
        if (studentManager.checkValidStudent(studentBuilder)) {
            return false;
        } else {
            studentManager.addStudent(studentBuilder);
            return true;
        }
    }
    public void addNewStudent(String username, String password){
        this.studentManager.addNewStudent(username,password);
    }

    public HashMap<String, StudentBuilder> getAllStudents(){
        return this.studentManager.getAllStudents();
    }


    public HashMap<String, ArrayList<CalendarEvent>> getCalendarRecurring(String username) {

        return studentManager.getCalendarRecurring(username);


    }

    public HashMap<Float, ArrayList<OneOffEvent>> getCalendarOneOff(String username) {

        return studentManager.getCalendarOneOff(username);


    }


    public  ArrayList<ArrayList<Object>> getTimes(String username, Float date, String day) {

        return studentManager.getTimes(username, date, day);


    }


}
