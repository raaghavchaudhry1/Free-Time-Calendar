package frontend;

import backend.*;
import calendar.CalendarController;
import login.LogIn;
import users.groups.GroupController;
import users.Person;
import users.students.StudentBuilder;
import users.students.StudentController;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUIRunner {
    public static void main(String[] args) {

        StudentController studentController = new StudentController();
        LogIn login = new LogIn(studentController);
        GroupController groupController = new GroupController();
        CalendarController calendarController = new CalendarController(studentController);

        JsonReader jsonReader = new JsonReader();

        try {
            if (jsonReader.savedInfoStudents()) {
                for (StudentBuilder studentBuilder : jsonReader.readStudentJson()) {
                    studentController.addStudent(studentBuilder);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (jsonReader.savedInfoGroups()) {
                HashMap<String, ArrayList<String>> groupHash = jsonReader.readGroupJsonSimplified();
                for (Map.Entry<String, ArrayList<String>> entry: groupHash.entrySet()) {
                    ArrayList<Person>  students = new ArrayList<>();
                    for (String username: entry.getValue()) {
                        students.add(studentController.getAllStudents().get(username));
                    }
                    groupController.createGroup(students, entry.getKey());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        new StartMenu(login, groupController, calendarController, studentController);

        ImageIcon logo = new ImageIcon("Images/Variable logo.png");

    }
}
