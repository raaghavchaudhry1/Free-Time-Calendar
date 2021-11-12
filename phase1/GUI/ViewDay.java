import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewDay {
    private LogIn loginController;
    private GroupController groupController;
    private String studentUsername;
    private CalendarController calendarController;
    private StudentController studentController;
    private float date;
    private String day;
    private JFrame frame;
    private HashMap<Float, String> timeTable;


    public ViewDay(LogIn loginController, GroupController groupController, CalendarController calendarController,
                   StudentController studentController, String studentUsername, Float date, String day) {

        this.timeTable = new HashMap<Float, String>();


        float i = 0;
        int counter = 0;
        while (i <= 24) {
            this.timeTable.put(i, "No Event");
            if (counter == 0) {
                counter ++;
                i += 0.3;

            } else {
                counter = 0;
                i += 0.7;

            }
        }

        System.out.println(this.timeTable);
        System.out.println(this.timeTable.size());


        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;
        this.date = date;
        this.day = day;

        this.frame = new JFrame();
        this.frame.setSize(300, 1200);
        this.frame.setLayout(new GridLayout(48, 2));
        this.frame.setVisible(true);


        HashMap<Float, ArrayList<OneOffEvent>> oneOffEvents = studentController.getCalendarOneOff(this.studentUsername);
        HashMap<String, ArrayList<CalendarEvent>> recurringEvents =
                studentController.getCalendarRecurring(this.studentUsername);

        ArrayList<CalendarEvent> dayRecurring = recurringEvents.get(this.day);
        ArrayList<OneOffEvent> dayOneOff = oneOffEvents.get(this.date);




        }



        






}








