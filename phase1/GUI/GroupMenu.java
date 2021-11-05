import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GroupMenu implements ActionListener {
    private JButton createGroup;
    private JButton joinGroup;
    private JButton viewGroups;
    private JFrame frame;

    // need username as a paramater for constructor
    public GroupMenu() {

        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500,500);
        this.createGroup = new JButton();
        this.createGroup.setBounds(10,80,80,25);
        this.createGroup.addActionListener(this);
        this.frame.add(this.createGroup);
        this.joinGroup = new JButton();
        this.joinGroup.setBounds(110,80,80,25);
        this.joinGroup.addActionListener(this);
        this.frame.add(this.createGroup);
        this.viewGroups = new JButton();
        this.viewGroups.setBounds(110,80,80,25);
        this.viewGroups.addActionListener(this);
        this.frame.add(this.createGroup);
        this.frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.viewGroups) {

            this.frame.dispose();
            ViewGroups viewGroups = new ViewGroups();


        } else if (e.getSource() == this.createGroup) {

            this.frame.dispose();
            CreateGroup createGroup = new CreateGroup();



        } else {

            this.frame.dispose();
            JoinGroup joinGroup = new JoinGroup();




        }


    }
}
