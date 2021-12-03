package frontend;

import calendar.CalendarController;
import users.groups.GroupController;
import login.LogIn;
import users.students.StudentController;
import login.LoginMenu;
import login.SignupMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** StartMenu class the first window that pops up.
 * With two options to continue, either logIn or SignUp */

public class StartMenu implements GUI {

    private JFrame frame;
    private JButton signupButton;
    private JButton loginButton;
    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;

    /** constructor StartMenu with 4 parameters
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     */

    public StartMenu(LogIn loginController, GroupController groupController,
                     CalendarController calendarController, StudentController studentController){

        setControllers(loginController, groupController, calendarController, studentController);
        this.frame = new JFrame();
//        this.frame.getContentPane().setBackground(Color.decode("#F4E2CB"));
//        this.frame.setForeground(Color.ORANGE);

//        ImageIcon logo = new ImageIcon(getClass() .getResource("Variable logo.png"));
//        JLabel displayField = new JLabel(logo);
//        frame.add(displayField);

//        ImageIcon image = new ImageIcon(getClass().getResource("/Images/Variable logo.png"));
//        JLabel imageLabel = new JLabel(image);
//        this.frame.add(imageLabel);


        this.frame.setLayout(null);
        this.frame.setSize(500,500);
        setLabelsAndText();
        setButtons();
        this.frame.setVisible(true);
    }


    @Override
    public void setLabelsAndText() {

    }

    @Override
    public void setButtons() {
        this.signupButton= new JButton("Sign up");
        this.loginButton=  new JButton("Login");
        this.loginButton.setBounds(100,200, 120, 30);
        this.signupButton.setBounds(250, 200, 120,30);
        this.loginButton.addActionListener(this);
        this.signupButton.addActionListener(this);
        this.frame.add(loginButton);
        this.frame.add(signupButton);
    }

    @Override
    public void setControllers(LogIn loginController, GroupController groupController, CalendarController calendarController, StudentController studentController) {
        this.loginController = loginController;
        this.groupController = groupController;
        this.studentController = studentController;
        this.calendarController = calendarController;
    }

    /** Makes button to perform based on a choice of a user.
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.signupButton){
            this.frame.dispose();
            SignupMenu signupMenu = new SignupMenu(this.loginController, this.groupController,
                    this.calendarController, this.studentController);
        }else if(e.getSource() == this.loginButton){
            this.frame.dispose();
            LoginMenu loginMenu = new LoginMenu(this.loginController, this.groupController,
                    this.calendarController, this.studentController);
        }
    }
}
