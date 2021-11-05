import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {
    private JFrame frame;
    private JButton addRecurButton;
    private JButton addOneOffButton;
    private JButton groupsButton;
    private JButton viewCalendarButton;
    private LogIn loginController;
    private GroupController groupController;
    private String studentUsername;
    // private StudentController studentController;

    //pass in parameters including username to access it in studentController
    public MainMenu(LogIn loginController, GroupController groupController, String studentUsername) {
        this.loginController = loginController;
        this.groupController = groupController;

        this.frame = new JFrame();
        this.addRecurButton= new JButton("Create Recurring Events");
        this.addOneOffButton=  new JButton("Create OneOff Events");
        this.groupsButton= new JButton("View Groups");
        this.viewCalendarButton=  new JButton("View Your Calendar");

        this.addRecurButton.setBounds(50,250, 100, 20);
        this.addOneOffButton.setBounds(200, 250, 100,20);
        this.groupsButton.setBounds(50,400, 100, 20);
        this.viewCalendarButton.setBounds(200, 400, 100,20);

        this.addRecurButton.addActionListener(this);
        this.addOneOffButton.addActionListener(this);
        this.groupsButton.addActionListener(this);
        this.viewCalendarButton.addActionListener(this);
        this.frame.setLayout(null);

        this.frame.add(addRecurButton);
        this.frame.add(addOneOffButton);
        this.frame.add(groupsButton);
        this.frame.add(viewCalendarButton);

        this.frame.setVisible(true);
        this.frame.setSize(500,500);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addRecurButton){
            this.frame.dispose();
            RecurringMenu recurringMenu = new RecurringMenu();
        }else if(e.getSource() == this.addOneOffButton){
            this.frame.dispose();
            OneOffMenu oneOffMenu = new OneOffMenu();

        }else if(e.getSource() == this.groupsButton){
            this.frame.dispose();
            GroupMenu groupMenu = new GroupMenu();

        }else if(e.getSource() == this.viewCalendarButton){
            this.frame.dispose();
            ViewCalenderMenu viewCalenderMenu = new ViewCalenderMenu();

        }

    }


}
