import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu implements ActionListener {

    private JFrame frame;
    private JButton signupButton;
    private JButton loginButton;
    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;


    public StartMenu(LogIn login, GroupController group,
                     CalendarController calendarController, StudentController studentController){
        this.loginController = login;
        this.groupController = group;
        this.studentController = studentController;
        this.calendarController = calendarController;
        this.frame = new JFrame();
        this.signupButton= new JButton("Sign up");
        this.loginButton=  new JButton("Login");
        this.loginButton.setBounds(100,200, 120, 30);
        this.signupButton.setBounds(250, 200, 120,30);
        this.loginButton.addActionListener(this);
        this.signupButton.addActionListener(this);
        this.frame.setLayout(null);
        this.frame.add(loginButton);
        this.frame.add(signupButton);
        this.frame.setVisible(true);
        this.frame.setSize(500,500);

    }

    public static void main(String[] args) {

        StudentController studentController = new StudentController();
        LogIn login = new LogIn(studentController);
        GroupController groupController = new GroupController();
        CalendarController calendarController = new CalendarController(studentController);
        new StartMenu(login, groupController, calendarController, studentController);
    }

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
