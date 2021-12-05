package events;
import backend.TaskList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class TaskListMenu extends JFrame implements ActionListener{
    JButton submitButton;
    JCheckBox checkBox;
    JFrame frame;

    TaskListMenu(){

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
//
//        JPanel panel = new JPanel();
//        panel.setSize(400, 400);
//        panel.setLayout(new GridLayout(0,0,5,10));


        this.submitButton = new JButton("Submit");
        this.submitButton.setBounds(30,120,200,40);
        this.submitButton.addActionListener(this);

        this.frame.add(submitButton);


        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (String i : cars) {
            this.checkBox = new JCheckBox();
            this.checkBox.setText(i);
            this.checkBox.setFocusable(false);
            this.checkBox.setFont(new Font("Consolas",Font.PLAIN,10));

            this.frame.add(this.checkBox);
            this.pack();
            this.setVisible(true);

            this.frame.add(this.checkBox);
        }




        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton) {
            System.out.println(checkBox.isSelected());
        }
    }

    public static void main(String[] args) {
        new TaskListMenu();
    }
}
