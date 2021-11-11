import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneOffMenu implements ActionListener {
    private JTextField eventNameText;
    private JFrame frame;
    private JButton returnButton;
    private JButton confirmButton;
    private JComboBox month;
    private JComboBox day;
    private JComboBox startHours;
    private JComboBox startMinutes;
    private JComboBox endHours;
    private JComboBox endMinutes;
    private String eventName;
    private float dateMonth;
    private float dateDay;
    private float startHour;
    private float startMinute;
    private float endHour;
    private float endMinute;
    private LogIn loginController;
    private GroupController groupController;


    public OneOffMenu() {
//        this.loginController = login;
//        this.groupController = group;
        String[] months = new String[12];
        String[] days = new String[31];
        for(int i = 0; i != 12; i++){
            months[i] = (String.valueOf(i + 1));
        }
        for(int i = 0; i != 31; i++){
            days[i] = (String.valueOf(i + 1));
        }
        String[] hours = new String[24];
        for(int i = 0; i != 24; i++){
            hours[i] = (String.valueOf(i));
        }
        String[] minutes = {"00", "30"};
        this.dateMonth = 0;
        this.dateDay = 0;
        this.startHour = 0;
        this.startMinute = 0;
        this.endHour = 0;
        this.endMinute = 0;

        this.eventName = "";
        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500,500);

        JLabel userLabel = new JLabel("Event Name");
        userLabel.setBounds(110,20,80,25);
        this.frame.add(userLabel);

        this.returnButton = new JButton("Return");
        this.returnButton.setBounds(0,0,100,20);
        this.returnButton.addActionListener(this);
        this.frame.add(this.returnButton);

        this.confirmButton = new JButton("Confirm");
        this.confirmButton.setBounds(250,400,100,30);
        this.confirmButton.addActionListener(this);
        this.frame.add(this.confirmButton);

        this.eventNameText = new JTextField();
        this.eventNameText.setBounds(200,20,150,25);
        this.frame.add(this.eventNameText);

        this.month = new JComboBox(months);
        this.month.setBounds(10,80,80,25);
        this.month.addActionListener(this);
        this.frame.add(this.month);

        this.day = new JComboBox(days);
        this.day.setBounds(90,80,80,25);
        this.day.addActionListener(this);
        this.frame.add(this.day);

        this.startHours = new JComboBox(hours);
        this.startHours.setBounds(200,80,50,25);
        this.startHours.addActionListener(this);
        this.frame.add(this.startHours);

        this.endHours = new JComboBox(hours);
        this.endHours.setBounds(320,80,50,25);
        this.endHours.addActionListener(this);
        this.frame.add(this.endHours);

        this.startMinutes = new JComboBox(minutes);
        this.startMinutes.setBounds(250,80,50,25);
        this.startMinutes.addActionListener(this);
        this.frame.add(this.startMinutes);

        this.endMinutes = new JComboBox(minutes);
        this.endMinutes.setBounds(370,80,50,25);
        this.endMinutes.addActionListener(this);
        this.frame.add(this.endMinutes);

        this.frame.setVisible(true);



    }

    public static void main(String[] args) {
        new OneOffMenu();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.returnButton){
            this.frame.dispose();
//            MainMenu mainMenu = new MainMenu();
        }else if(e.getSource() == this.month){
            this.dateMonth = (float) month.getSelectedItem()  ;

        }else if(e.getSource() == this.day){
            this.dateDay = (float) day.getSelectedItem()  ;

        }else if(e.getSource() == this.startMinutes){
            this.startMinute = (float) startMinutes.getSelectedItem();

        }else if(e.getSource() == this.startHours){
            this.startHour = (float) startHours.getSelectedItem();

        }else if(e.getSource() == this.endMinutes){
            this.endMinute = (float) endMinutes.getSelectedItem();

        }else if(e.getSource() == this.endHours){
            this.endHour = (float) endMinutes.getSelectedItem();

        }else if(e.getSource() == this.confirmButton){
            this.frame.dispose();
            //use EventController to create event to add to user.

        }

    }
}
