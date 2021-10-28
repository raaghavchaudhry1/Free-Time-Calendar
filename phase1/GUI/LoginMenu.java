import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu implements ActionListener {
    private JTextField userText;
    private JPasswordField passwordText;
    private JFrame frame;
    private JButton cancelButton;
    private JButton loginButton;
    private String username;
    private String password;

    public LoginMenu() {
        this.username = new String();
        this.password = new String();

        this.frame = new JFrame();

//        this.loginButton.addActionListener(this);
//        this.cancelButton.addActionListener(this);

        this.frame.setLayout(null);
        this.frame.setSize(500,500);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        this.frame.add(userLabel);

        this.userText = new JTextField();
        this.userText.setBounds(100,20,165,25);
        this.frame.add(this.userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        this.frame.add(passwordLabel);

        this.passwordText = new JPasswordField();
        this.passwordText.setBounds(100,50,165,25);
        this.frame.add(this.passwordText);

        this.loginButton = new JButton("Log In");
        this.loginButton.setBounds(10,80,80,25);
        this.loginButton.addActionListener(this);
        this.frame.add(this.loginButton);

        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setBounds(100,80,80,25);
        this.cancelButton.addActionListener(this);
        this.frame.add(this.cancelButton);

        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.cancelButton){
            this.frame.dispose();
            StartMenu startMenu = new StartMenu();
        }else if(e.getSource() == this.loginButton){
            this.username = this.userText.getText();
            this.password = this.passwordText.getText();
            //check for correct login credentials
            System.out.println(this.username);
            System.out.println(this.password);
            this.frame.dispose();


        }
    }

    public static void main(String[] args) {
        new LoginMenu();
    }
}
