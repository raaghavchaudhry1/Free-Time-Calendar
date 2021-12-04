package users.groups;

import calendar.CalendarController;
import frontend.GUI;
import frontend.MainMenu;
import login.LogIn;
import users.students.StudentController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** CreateGroupPopUp window is a confirmation that the group was created successfully.*/

public class CreateGroupPopUp implements GUI {

    private JFrame frame;
    private JLabel groupIdPopUp;
    private JLabel groupIdPopUp2;
    private JLabel groupIdPopUp3;
    private JLabel groupIdPopUp4;

    private JButton returnHome;

    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;
    private String studentUsername;

    private String ID;

    /** This constructor is used for confirming that a new Groupis created, has 5 parameters
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     * @param studentUsername
     * */

    public CreateGroupPopUp(LogIn loginController, GroupController groupController, CalendarController calendarController,
                            StudentController studentController, String studentUsername, String ID){
        setControllers(loginController, groupController, calendarController, studentController);
        this.studentUsername = studentUsername;

        this.frame =  new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(250,250);
        this.ID = ID;
        setButtons();
        setLabelsAndText();
        this.frame.setVisible(true);
    }

    @Override
    public void setLabelsAndText() {
        groupIdPopUp = new JLabel("The Group is successfully ");
        groupIdPopUp.setBounds(25,20,200,35);
        this.frame.add(groupIdPopUp);

        groupIdPopUp2 = new JLabel("created!");
        groupIdPopUp2.setBounds(25,45,200,35);
        this.frame.add(groupIdPopUp2);

        String s = String.format("Your Group ID is : %s", this.ID);
        groupIdPopUp3 = new JLabel(s);
        groupIdPopUp3.setBounds(35,110,200,35);
        this.frame.add(groupIdPopUp3);

        groupIdPopUp4 = new JLabel("Please record the Group ID");
        groupIdPopUp4.setBounds(35,140,200,35);
        this.frame.add(groupIdPopUp4);
    }

    @Override
    public void setButtons() {
        returnHome = new JButton("Return");
        returnHome.setBounds(55,170,120,30);
        this.returnHome.addActionListener(this);
        this.frame.add(returnHome);
    }

    @Override
    public void setControllers(LogIn loginController, GroupController groupController, CalendarController calendarController, StudentController studentController) {
        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
    }

    /** Makes button to perform based on a choice of a user.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.returnHome){
            this.frame.dispose();
            new MainMenu(this.loginController, this.groupController, this.calendarController,
                        this.studentController, this.studentUsername);
        }
    }
}


