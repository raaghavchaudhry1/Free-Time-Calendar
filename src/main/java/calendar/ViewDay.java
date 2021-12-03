package calendar;

import users.groups.GroupController;
import login.LogIn;
import users.students.StudentController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/** ViewDay window is to check all the planned meeting during a selected day.*/

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

    /** constructor ViewDay with 7 parameters
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     * @param studentUsername
     * @param date
     * @param day
     */
    public ViewDay(LogIn loginController, GroupController groupController, CalendarController calendarController,
                   StudentController studentController, String studentUsername, Float date, String day) {

        this.timeTable = new HashMap<Float, String>();
        float i = 0;
        int counter = 0;
        while (i < 24) {
            this.timeTable.put(i, "No Event");
            if (counter == 0) {
                counter++;
                i += 0.3;

            } else {
                counter = 0;
                i += 0.7;
            }
        }
        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;
        this.date = date;
        this.day = day;

        this.frame = new JFrame();
        this.frame.setSize(300, 1200);

        this.populate();
        String[][] data = this.convertHashMapToNestedArray();


        String [] coloumnNames = {"Time", "Event"};
        this.table = new JTable(data, coloumnNames);
        this.frame.add(this.table);
        this.frame.setVisible(true);
    }

    /** This constructor is used for creating a new window of a events during the day, has 5 parameters
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     * @param studentUsername
     * */
    public ViewDay(LogIn loginController, GroupController groupController, CalendarController calendarController,
                   StudentController studentController, String studentUsername) {

        this.timeTable = new HashMap<Float, String>();
        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;
        this.frame = new JFrame();
        this.frame.setSize(300, 1200);
    }


    /** populate method populates Hashmap */
    public void populate() {
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

    /** convertHashMapToNestedArray method converts Hashmap to a Nested Array*/
    public String[][] convertHashMapToNestedArray(){

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

    public LogIn getLoginController() {
        return loginController;
    }

    public GroupController getGroupController() {
        return groupController;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public CalendarController getCalendarController() {
        return calendarController;
    }

    public StudentController getStudentController() {
        return studentController;
    }

    public float getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public JFrame getFrame() {
        return frame;
    }

    public HashMap<Float, String> getTimeTable() {
        return timeTable;
    }

    public JTable getTable() {
        return table;
    }
    public void setDate(float date) {
        this.date = date;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}








