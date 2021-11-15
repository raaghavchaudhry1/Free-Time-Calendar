package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StudentController {

    private StudentManager studentManager;

    public StudentController(){
        this.studentManager = new StudentManager();
    }

    public boolean addStudent(Student student) {
        // returns true if student has been added to hashmap, false if student already exists
        if (studentManager.checkValidStudent(student)) {
            return false;
        } else {
            studentManager.addStudent(student);
            return true;
        }
    }
    public void addNewStudent(String username, String password){
        this.studentManager.addNewStudent(username,password);
    }

    public HashMap<String, Student> getAllStudents(){
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
