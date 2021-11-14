import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;

import javax.swing.*;

/** CalendarFrame window is where the monthly calendar presented.*/

public class CalendarFrame implements ActionListener {

    private JFrame frame;
    private int currentYear;
    private int currentMonth;
    private JButton previousMonth;
    private JButton nextMonth;
    private LogIn loginController;
    private GroupController groupController;
    private String studentUsername;
    private CalendarController calendarController;
    private StudentController studentController;

    /**
     * constructor CalendarFrame with 4 parameters
     *
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     * @param studentUsername
     * @param currentMonth
     * @param currentYear
     */
    public CalendarFrame(LogIn loginController, GroupController groupController,
                         CalendarController calendarController,
                         StudentController studentController, String studentUsername,
                         int currentMonth, int currentYear) {

        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;

        MonthPanel panel = new MonthPanel(this.currentMonth, this.currentYear, this.loginController,
                this.groupController, this.calendarController, this.studentController, this.studentUsername);

        frame = new JFrame();
        frame.setTitle("Calendar");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        this.previousMonth = new JButton("Prev");
        this.previousMonth.setBounds(10, 10, 80, 25);
        this.previousMonth.addActionListener(this);
        this.frame.add(this.previousMonth);

        this.nextMonth = new JButton("Next");
        this.nextMonth.setBounds(100, 10, 80, 25);
        this.nextMonth.addActionListener(this);
        this.frame.add(this.nextMonth);

        frame.setLayout(new FlowLayout());
        frame.add(panel);
        frame.pack();
        // frame.setBounds(100, 100, 400, 200);
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    /**
     * Makes button to perform based on a choice of a user.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.previousMonth) {
            this.frame.dispose();
            if (this.currentMonth == 0) {
                new CalendarFrame(this.loginController, this.groupController,
                        this.calendarController, this.studentController,
                        this.studentUsername, 11, this.currentYear - 1);
            } else {
                new CalendarFrame(this.loginController, this.groupController,
                        this.calendarController, this.studentController,
                        this.studentUsername, this.currentMonth - 1, this.currentYear);
            }

        } else if (e.getSource() == this.nextMonth) {
            this.frame.dispose();
            if (this.currentMonth == 11) {
                new CalendarFrame(this.loginController, this.groupController,
                        this.calendarController, this.studentController,
                        this.studentUsername, 0, this.currentYear + 1);
            } else {
                new CalendarFrame(this.loginController, this.groupController,
                        this.calendarController, this.studentController,
                        this.studentUsername, this.currentMonth + 1, this.currentYear);
            }
        }
    }
}
