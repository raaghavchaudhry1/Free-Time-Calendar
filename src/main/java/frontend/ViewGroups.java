package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/** ViewGroups window is to view current joined groups.*/

public class ViewGroups implements ActionListener {

    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;
    private String studentUsername;
    private JFrame frame;
    private HashMap<JButton, String> mappings;
    private  JButton back;
    private JLabel noGroups;

    /** constructor ViewGroups with 5 parameters
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     * @param studentUsername
     */

    public ViewGroups(LogIn loginController, GroupController groupController, CalendarController calendarController,
                      StudentController studentController, String studentUsername)  {

        this.mappings = new HashMap<JButton, String>();
        this.back = new JButton("Return Home");
        this.back.setBounds(0,0,200,200);
        this.back.addActionListener(this);

        this.frame = new JFrame();
        frame.setSize(750, 750);

        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;
        this.frame.setLayout(new GridLayout(6, 6));
        Student curr = studentController.getAllStudents().get(this.studentUsername);
        ArrayList<ArrayList<Object>> groups = this.groupController.getStudentGroups(curr);
        this.noGroups = new JLabel("You aren't in any Groups!");
        this.noGroups.setBounds(600, 600, 200, 200 );
        this.frame.add(back);

        if (groups.isEmpty()) {
            this.frame.add(this.noGroups);
        }
        for (ArrayList<Object> temp : groups) {
            String s = (String) temp.get(1);
            String s1 = String.format("View Group: %s", s);
            JButton button = new JButton(s1);
            button.addActionListener(this);
            String groupID = (String) temp.get(2);
            this.frame.add(button);
            this.mappings.put(button, groupID);
        }
        this.frame.setVisible(true);
    }

    /** Makes button to perform based on a choice of a user.
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button: this.mappings.keySet()) {
            if (e.getSource() == button) {
                String gID = this.mappings.get(button);
                new ViewIndividualGroup(this.loginController, this.groupController,
                        this.calendarController, this.studentController, this.studentUsername, gID);
            }
        }
        if (e.getSource() == this.back) {
            this.frame.dispose();
            MainMenu menu = new MainMenu(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);
        }
    }
}
