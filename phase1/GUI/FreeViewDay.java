import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class FreeViewDay extends ViewDay{
    public FreeViewDay(LogIn loginController, GroupController groupController,
                       CalendarController calendarController,
                       StudentController studentController, String studentUsername,
                       Float date, String day, String gID) {

        super(loginController, groupController, calendarController, studentController, studentUsername);

        float i = 0;
        int counter = 0;
        while (i <= 24) {
            super.getTimeTable().put(i, "Occupied");
            if (counter == 0) {
                counter++;
                i += 0.3;

            } else {
                counter = 0;
                i += 0.7;

            }
        }
        super.setDate(date);
        super.setDay(day);
        FreeTimeCalculator freeTimeCalculator = new FreeTimeCalculator();
        ArrayList<HashMap> schedules = freeTimeCalculator.getFreeCalendar(super.getGroupController(), gID);
        HashMap<String, ArrayList<CalendarEvent>> recurringEvents = schedules.get(0);
        HashMap<Float, ArrayList<OneOffEvent>> oneOffEvents = schedules.get(1);

        ArrayList<CalendarEvent> dayRecurring = recurringEvents.get(super.getDay());
        ArrayList<OneOffEvent> dayOneOff = oneOffEvents.get(super.getDate());

        this.populate(dayRecurring, dayOneOff);
        String[][] data = super.convertHashMapToNestedArray();


        String [] coloumnNames = {"Time", "Event"};
        super.setTable(new JTable(data, coloumnNames));
        super.getFrame().add(super.getTable());
        super.getFrame().setVisible(true);
    }
}
