package login;

import calendar.CalendarController;
import frontend.GUI;
import frontend.StartMenu;
import users.groups.GroupController;
import users.students.StudentController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** SignupMenu is window where a student can register in the app. */

public class SignupMenu implements GUI {
    private JTextField userText;
    private JPasswordField passwordText;
    private JFrame frame;
    private JButton signUpButton;
    private JButton cancelButton;
    private String username;
    private String password;
    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;

    /** Constructs a new student, and stores his input (login and password), has 4 parameters
     * @param loginController
     * @param groupController
     * @param calendarController
     * @param studentController
     */
    public SignupMenu(LogIn loginController, GroupController groupController,
                      CalendarController calendarController, StudentController studentController) {
        setControllers(loginController, groupController, calendarController, studentController);
        this.username = new String();
        this.password = new String();
        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500, 500);
        setButtons();
        setLabelsAndText();
//        this.frame.getContentPane().setBackground(Color.decode("#F4E2CB"));
        this.frame.setVisible(true);
    }

    @Override
    public void setLabelsAndText() {
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10,20,80,25);
        this.frame.add(userLabel);

        this.userText = new JTextField();
        this.userText.setBounds(100,20,165,25);
        this.frame.add(this.userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        this.frame.add(passwordLabel);

        this.passwordText = new JPasswordField();
        this.passwordText.setBounds(100,50,165,25);
        this.frame.add(this.passwordText);
    }

    @Override
    public void setButtons() {
        this.signUpButton = new JButton("Sign Up");
        this.signUpButton.setBounds(10,80,80,25);
        this.signUpButton.addActionListener(this);
        this.frame.add(this.signUpButton);

        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setBounds(100,80,80,25);
        this.cancelButton.addActionListener(this);
        this.frame.add(this.cancelButton);
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
        if(e.getSource() == this.signUpButton){
            this.username = this.userText.getText();
            this.password = this.passwordText.getText();
            this.studentController.addNewStudent(this.username, this.password);

            this.frame.dispose();
            StartMenu startMenu = new StartMenu(this.loginController, this.groupController,
                    this.calendarController, this.studentController);

        }else if(e.getSource() == this.cancelButton){
            this.frame.dispose();
            StartMenu startMenu = new StartMenu(this.loginController, this.groupController,
                    this.calendarController, this.studentController);
        }
    }

}
