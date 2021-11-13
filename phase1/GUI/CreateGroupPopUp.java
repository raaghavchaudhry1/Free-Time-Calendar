import javax.swing.*;

public class CreateGroupPopUp {

    private JFrame frame;
    private JLabel groupIdPopUp;
    private JLabel groupIdPopUp2;
    private JLabel groupIdPopUp3;

    public CreateGroupPopUp(){
        this.frame =  new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(250,250);

        groupIdPopUp = new JLabel("The Group is successfully ");
        groupIdPopUp.setBounds(25,30,200,35);
        this.frame.add(groupIdPopUp);

        groupIdPopUp = new JLabel("created!");
        groupIdPopUp.setBounds(25,55,200,35);
        this.frame.add(groupIdPopUp);



        groupIdPopUp3 = new JLabel("Your Group ID is ###");
        groupIdPopUp3.setBounds(35,120,150,35);
        this.frame.add(groupIdPopUp3);

        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CreateGroupPopUp();
    }


}
