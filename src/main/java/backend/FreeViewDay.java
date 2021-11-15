import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;



public class FreeViewDay extends ViewDay{
    private String gID;
    private float date;
    private String day;
    public FreeViewDay(LogIn loginController, GroupController groupController,
                       CalendarController calendarController,
                       StudentController studentController, String studentUsername,
                       Float date, String day, String gID) {

        super(loginController, groupController, calendarController, studentController, studentUsername);
        this.gID = gID;
        this.date = date;
        this.day = day;

        float i = 0;
        int counter = 0;
        while (i < 24) {
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

        this.populate();
        String[][] data = super.convertHashMapToNestedArray();


        String [] coloumnNames = {"Time", "Event"};
        super.setTable(new JTable(data, coloumnNames));
        super.getFrame().add(super.getTable());
        super.getFrame().setVisible(true);
    }

    @Override
    public void populate() {

        ArrayList<ArrayList<Object>> times =
                super.getGroupController().getFreeTimes(this.gID, this.date, this.day);

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
                super.getTimeTable().put(i, (String) curr.get(2));
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
}
