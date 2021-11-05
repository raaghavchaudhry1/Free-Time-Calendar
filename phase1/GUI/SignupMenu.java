import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupMenu {
    private JTextField userText;
    private JPasswordField passwordText;
    private JFrame frame;
    private JButton signUp;
    private String username;
    private String password;

    public SignupMenu() {
        this.username = new String();
        this.password = new String();
        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500,500);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10,20,80,25);
        this.frame.add(userLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        this.frame.add(passwordLabel);











    }









}
