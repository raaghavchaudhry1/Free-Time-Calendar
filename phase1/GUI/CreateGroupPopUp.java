import javax.swing.*;

public class CreateGroupPopUp {

    private JFrame frame;
    private JLabel groupIdPopUp;
    private JLabel groupIdPopUp2;
    private JLabel groupIdPopUp3;
    private JLabel GroupIdPopUp4;

    private String ID;

    public CreateGroupPopUp(String ID){
        this.frame =  new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(250,250);
        this.ID = ID;

        groupIdPopUp = new JLabel("The Group is successfully ");
        groupIdPopUp.setBounds(25,30,200,35);
        this.frame.add(groupIdPopUp);

        groupIdPopUp2 = new JLabel("created!");
        groupIdPopUp2.setBounds(25,55,200,35);
        this.frame.add(groupIdPopUp2);


        String s = String.format("Your Group ID is : %s", this.ID);
        groupIdPopUp3 = new JLabel(s);
        groupIdPopUp3.setBounds(35,120,200,35);
        this.frame.add(groupIdPopUp3);

        groupIdPopUp2 = new JLabel("Please record the Group ID");
        groupIdPopUp2.setBounds(35,170,200,35);
        this.frame.add(groupIdPopUp2);


        this.frame.setVisible(true);
    }




}
