import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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
    private JTable table;


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



        HashMap<Float, ArrayList<OneOffEvent>> oneOffEvents = studentController.getCalendarOneOff(this.studentUsername);
        HashMap<String, ArrayList<CalendarEvent>> recurringEvents =
                studentController.getCalendarRecurring(this.studentUsername);

        ArrayList<CalendarEvent> dayRecurring = recurringEvents.get(this.day);
        ArrayList<OneOffEvent> dayOneOff = oneOffEvents.get(this.date);

        this.populate(dayRecurring, dayOneOff);
        String[][] data = convertHashMapToNestedArray();


        String [] coloumnNames = {"Time", "Event"};
        this.table = new JTable(data, coloumnNames);
        this.frame.add(this.table);
        this.frame.setVisible(true);
    }


    public void populate(ArrayList<CalendarEvent> dayRecurring,
                         ArrayList<OneOffEvent> dayOneOff) {

        ArrayList<ArrayList<Object>> times = this.studentController.getTimes(this.studentUsername, this.date, this.day);

        for (ArrayList<Object> curr : times) {

            float start = (float) curr.get(0);
            float end = (float) curr.get(1);

            float i = start;
            int counter;

            if ((int) (start) == (start)) {
                counter = 0;
            } else {
                counter = 1;
            }

            while (i < end) {
                timeTable.put(i, (String) curr.get(2));
                if (counter == 0) {
                    counter++;
                    i += 0.3;

                } else {
                    counter = 0;
                    i += 0.7;

                }

            }
        }

    }

    private String[][] convertHashMapToNestedArray(){

        int length = timeTable.size();
        String[][] arrayToReturn = new String[length][2];
        ArrayList<Float> sortedKeys = new ArrayList(timeTable.keySet());
        Collections.sort(sortedKeys);

        for (int i = 0; i != length; i++){
            for (int j = 0 ; j != 2; j++){
                if(j == 0){
                    arrayToReturn[i][j] = String.valueOf(sortedKeys.get(i)).replaceAll("[.]",":");
                }else{
                    arrayToReturn[i][j] = timeTable.get(sortedKeys.get(i));
                }
            }
        }
        return arrayToReturn;
    }
}








