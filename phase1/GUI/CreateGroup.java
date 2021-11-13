import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateGroup implements ActionListener {

    private JFrame frame;
    private JTextField groupName;
    private JButton submitButton;
    private JButton cancelButton;

    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;
    private String studentUsername;

    public CreateGroup(LogIn loginController, GroupController groupController, CalendarController calendarController,
                       StudentController studentController, String studentUsername){

        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;

        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500,500);

        JLabel groupNameLabel = new JLabel("Group Name: ");
        groupNameLabel.setBounds(110,50,115, 30);
        this.frame.add(groupNameLabel);

        this.groupName = new JTextField();
        this.groupName.setBounds(210,50,165,30);
        this.frame.add(this.groupName);

        this.submitButton = new JButton("Submit");
        this.submitButton.setBounds(100,100,100,30);
        this.submitButton.addActionListener(this);
        this.frame.add(this.submitButton);

        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setBounds(240,100,100,30);
        this.cancelButton.addActionListener(this);
        this.frame.add(this.cancelButton);



        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.submitButton){

            HashMap<String, Student> studentHashMap =  this.studentController.getAllStudents();
            Student curr =  studentHashMap.get(this.studentUsername);
            ArrayList<Student> newGroup = new ArrayList<Student>();
            newGroup.add(curr);

            String name = this.groupName.getText();
            Group group = this.groupController.createGroup(newGroup, name);
            String ID = this.groupController.getID(group);




            this.frame.dispose();
            new CreateGroupPopUp(ID);


//            this.frame.dispose();
//            MainMenu menu = new MainMenu(this.loginController, this.groupController, this.calendarController,
//                        this.studentController, this.studentUsername);


        }
        else if(e.getSource() == this.cancelButton){
            this.frame.dispose();
            GroupMenu menu = new GroupMenu(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);
//            going back to GroupMenu
        }
    }

//    public static void main(String[] args) {
//        new CreateGroup();
//    }
}
