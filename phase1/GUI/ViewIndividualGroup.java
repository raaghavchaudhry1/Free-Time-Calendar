import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ViewIndividualGroup implements ActionListener {

    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;
    private String studentUsername;
    private String gID;
    private JButton back;
    private JFrame frame;
    private HashMap<JButton, String> mappings;
    private JButton freeTime;





    public ViewIndividualGroup(LogIn loginController, GroupController groupController, CalendarController calendarController,
                               StudentController studentController, String studentUsername, String gID) {

        this.frame = new JFrame();
        this.frame.setSize(300, 1200);
        this.frame.setLayout(new GridLayout(6, 6));


        this.mappings = new HashMap<JButton, String>();
        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;
        this.gID = gID;
        this.freeTime = new JButton("View Shared Freetime Calendar");
        this.freeTime.addActionListener(this);
        this.back = new JButton("Return Home");
        this.back.addActionListener(this);
        this.frame.add(back);
        this.frame.add(freeTime);


        ArrayList<String> list = this.groupController.getStudentUsername(gID);
        for (String username: list) {
            String s = username;
            String s1 = String.format("Delete Group Member : %s", s);
            JButton button = new JButton(s1);
            button.addActionListener(this);
            this.frame.add(button);
            this.mappings.put(button, username);
        }


        this.frame.setVisible(true);

















    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton button: this.mappings.keySet()) {

            if (e.getSource() == button) {
                String username = this.mappings.get(button);
                Student curr = this.studentController.getAllStudents().get(username);
                this.groupController.removeMember(curr, this.gID);
                this.frame.dispose();
                new ViewIndividualGroup(this.loginController, this.groupController,
                        this.calendarController, this.studentController, this.studentUsername, gID);


            }


        }


        if (e.getSource() == this.back) {

            this.frame.dispose();
            MainMenu menu = new MainMenu(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);


        } else {

            this.frame.dispose();
            GregorianCalendar cal = new GregorianCalendar();
            int realMonth = cal.get(GregorianCalendar.MONTH);
            int realYear = cal.get(GregorianCalendar.YEAR);
            new FreeCalendarFrame(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername, realMonth, realYear, this.gID);



        }
    }
}
