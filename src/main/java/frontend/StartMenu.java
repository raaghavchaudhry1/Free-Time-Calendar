package frontend;

import backend.CalendarController;
import backend.GroupController;
import backend.LogIn;
import backend.StudentController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** StartMenu class the first window that pops up.
 * With two options to continue, either logIn or SignUp */

public class StartMenu implements ActionListener {

    private JFrame frame;
    private JButton signupButton;
    private JButton loginButton;
    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;

    /** constructor StartMenu with 4 parameters
     * @param  login
     * @param group
     * @param calendarController
     * @param studentController
     */

    public StartMenu(LogIn login, GroupController group,
                     CalendarController calendarController, StudentController studentController){

        this.loginController = login;
        this.groupController = group;
        this.studentController = studentController;
        this.calendarController = calendarController;
        this.frame = new JFrame();
//        this.frame.getContentPane().setBackground(Color.decode("#F4E2CB"));
//        this.frame.setForeground(Color.ORANGE);

//        ImageIcon logo = new ImageIcon(getClass() .getResource("Variable logo.png"));
//        JLabel displayField = new JLabel(logo);
//        frame.add(displayField);

//        ImageIcon image = new ImageIcon(getClass().getResource("/Images/Variable logo.png"));
//        JLabel imageLabel = new JLabel(image);
//        this.frame.add(imageLabel);

        this.signupButton= new JButton("Sign up");

        this.loginButton=  new JButton("Login");
        this.loginButton.setBounds(100,200, 120, 30);
        this.signupButton.setBounds(250, 200, 120,30);
        this.loginButton.addActionListener(this);
        this.signupButton.addActionListener(this);
        this.frame.setLayout(null);
        this.frame.add(loginButton);
        this.frame.add(signupButton);

        this.frame.setSize(500,500);





        this.frame.setVisible(true);
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
