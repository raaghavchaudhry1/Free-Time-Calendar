package frontend;

import calendar.CalendarController;
import login.LogIn;
import users.groups.GroupController;
import users.students.StudentController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface GUI extends ActionListener {

    public void setLabelsAndText();

    public void setButtons();

    public void setControllers(LogIn loginController, GroupController groupController, CalendarController calendarController,
                                      StudentController studentController);

    @Override
    public void actionPerformed(ActionEvent e);
}
