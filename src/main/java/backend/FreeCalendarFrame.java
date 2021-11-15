import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;

/** FreetimeCalendarFrame is a subclass of CalendarFrame*/

public class FreeCalendarFrame extends CalendarFrame{
    private String gID;
    public FreeCalendarFrame(LogIn loginController, GroupController groupController,
                             CalendarController calendarController,
                             StudentController studentController, String studentUsername,
                             int currentMonth, int currentYear, String gID){
        super(loginController, groupController,
                calendarController, studentController, studentUsername);
        this.gID = gID;
        FreeMonthPanel panel = new FreeMonthPanel(currentMonth, currentYear, super.getLoginController(),
                super.getGroupController(), super.getCalendarController(),
                super.getStudentController(), super.getStudentUsername(), this.gID);
        super.getFrame().add(panel);
        super.getFrame().setVisible(true);
    }

}
