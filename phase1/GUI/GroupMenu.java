import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GroupMenu implements ActionListener {
    private JButton createGroup;
    private JButton joinGroup;
    private JButton viewGroups;
    private JFrame frame;
    private JButton homeMenu;

    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;
    private String studentUsername;

    // need username as a paramater for constructor
    public GroupMenu(LogIn loginController, GroupController groupController, CalendarController calendarController,
                     StudentController studentController, String studentUsername) {

        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;


        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500,500);

        this.joinGroup = new JButton("Join Group");
        this.joinGroup.setBounds(30,120,200,40);
        this.joinGroup.addActionListener(this);
        this.frame.add(this.joinGroup);

        this.createGroup = new JButton("Create Group");
        this.createGroup.setBounds(250,120,200,40);
        this.createGroup.addActionListener(this);
        this.frame.add(this.createGroup);

        this.viewGroups = new JButton("View Groups");
        this.viewGroups.setBounds(30,200,200,40);
        this.viewGroups.addActionListener(this);
        this.frame.add(this.viewGroups);

        this.homeMenu = new JButton("Return to Home Menu");
        this.homeMenu.setBounds(250,200,200,40);
        this.homeMenu.addActionListener(this);
        this.frame.add(this.homeMenu);
        this.frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.viewGroups) {

            this.frame.dispose();
            ViewGroups viewGroups = new ViewGroups(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);


        } else if (e.getSource() == this.createGroup) {

            this.frame.dispose();
            CreateGroup createGroup = new CreateGroup(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);


        } else if (e.getSource() == this.joinGroup){

            this.frame.dispose();
            JoinGroup joinGroup = new JoinGroup(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);


        } else {

            this.frame.dispose();
            MainMenu menu = new MainMenu(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);
           // new StartMenu()
            //add this when controller classes created


        }



    }
}
