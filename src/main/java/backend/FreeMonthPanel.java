import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
/** FreeMontPanel is a subclass of MonthPanel*/
public class FreeMonthPanel extends MonthPanel{
    private String gID;

    /** constructor FreeMonthPanel has 8 parameters
     * @param month
     * @param year
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     * @param studentUsername
     * @param gID
     */
    public FreeMonthPanel(int month, int year, LogIn loginController,
                          GroupController groupController, CalendarController calendarController,
                          StudentController studentController, String studentUsername, String gID) {
        super(month, year, loginController, groupController, calendarController, studentController, studentUsername);
        this.gID = gID;
    }

    /** Makes button to perform based on a choice of a user.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < super.getButtons().size(); i++) {
            if (e.getSource() == super.getButtons().get(i)) {
                int day = i +  1;
                Float date = (float) this.month + 1 + (float)(day) / 100;
                GregorianCalendar calendar = new GregorianCalendar(this.year, this.month, day);
                int week = calendar.get(Calendar.DAY_OF_WEEK);
                String dayOfWeek;
                if(week == 2){
                    dayOfWeek = "Monday";
                } else if (week==3){
                    dayOfWeek = "Tuesday";
                } else if (week==4){
                    dayOfWeek = "Wednesday";
                } else if (week==5){
                    dayOfWeek = "Thursday";
                } else if (week==6){
                    dayOfWeek = "Friday";
                } else if (week==7){
                    dayOfWeek = "Saturday";
                } else{
                    dayOfWeek = "Sunday";
                }

                new FreeViewDay(super.getLoginController(), super.getGroupController(),
                        super.getCalendarController(), super.getStudentController(), super.getStudentUsername(),
                        date, dayOfWeek, this.gID);
            }
        }
    }
}
