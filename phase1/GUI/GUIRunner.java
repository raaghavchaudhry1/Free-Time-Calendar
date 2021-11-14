import javax.swing.*;

public class GUIRunner {
    public static void main(String[] args) {

        StudentController studentController = new StudentController();
        LogIn login = new LogIn(studentController);
        GroupController groupController = new GroupController();
        CalendarController calendarController = new CalendarController(studentController);
        new StartMenu(login, groupController, calendarController, studentController);

        ImageIcon logo = new ImageIcon("Images/Variable logo.png");

    }
}
