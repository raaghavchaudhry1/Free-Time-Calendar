import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUIRunner {
    public static void main(String[] args) {

        StudentController studentController = new StudentController();
        LogIn login = new LogIn(studentController);
        GroupController groupController = new GroupController();
        CalendarController calendarController = new CalendarController(studentController);

        JsonReader jsonReader = new JsonReader();

        try {
            if (jsonReader.savedInfoStudents()) {
                for (Student student: jsonReader.readStudentJson()) {
                    studentController.addStudent(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (jsonReader.savedInfoGroups()) {
                for (Group group: jsonReader.readGroupJson()) {
                    groupController.createGroup(group.getMembers(), group.getGroupName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        new StartMenu(login, groupController, calendarController, studentController);

        ImageIcon logo = new ImageIcon("Images/Variable logo.png");

    }
}
