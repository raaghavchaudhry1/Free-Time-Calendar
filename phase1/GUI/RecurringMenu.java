//import javax.swing.*;
//import java.awt.event.ActionEvent;
//
//public class RecurringMenu {
//    private JTextField eventNameText;
//    private JFrame frame;
//    private JComboBox daysOfWeek;
//    private JComboBox startHours;
//    private JComboBox startMinutes;
//    private JComboBox endHours;
//    private JComboBox endMinutes;
//    private String eventName;
//    private LogIn loginController;
//    private GroupController groupController;
//
//    public RecurringMenu() {
////        this.loginController = login;
////        this.groupController = group;
//        String[] days = {"Monday", "Tuesday", "Wednesday",
//                "Thursday", "Friday", "Saturday", "Sunday"};
//        String[] hours = new String[24];
//
//        this.eventName = new String();
//        this.frame = new JFrame();
//        this.frame.setLayout(null);
//        this.frame.setSize(500,500);
//
//        JLabel userLabel = new JLabel("Event Name");
//        userLabel.setBounds(10,20,80,25);
//        this.frame.add(userLabel);
//
//        this.eventNameText = new JTextField();
//        this.eventNameText.setBounds(100,20,165,25);
//        this.frame.add(this.eventNameText);
//
//        this.daysOfWeek = new JComboBox("Sign Up");
//        this.signUpButton.setBounds(10,80,80,25);
//        this.signUpButton.addActionListener(this);
//        this.frame.add(this.signUpButton);
//
//        this.cancelButton = new JButton("Cancel");
//        this.cancelButton.setBounds(100,80,80,25);
//        this.cancelButton.addActionListener(this);
//        this.frame.add(this.cancelButton);
//
//        this.frame.setVisible(true);
//
//
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == this.signUpButton){
//            this.username = this.userText.getText();
//            this.password = this.passwordText.getText();
////            this.studentController.addStudent(this.username, this.password);
//
//            this.frame.dispose();
//            StartMenu startMenu = new StartMenu(this.loginController, this.groupController);
//
//        }else if(e.getSource() == this.cancelButton){
//            this.frame.dispose();
//            StartMenu startMenu = new StartMenu(this.loginController, this.groupController);
//
//        }
//    }
//}
