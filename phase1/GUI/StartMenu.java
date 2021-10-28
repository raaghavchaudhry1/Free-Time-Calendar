import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu implements ActionListener {

    private JFrame frame;
    private JButton signupButton;
    private JButton loginButton;

    public StartMenu(){
        this.frame = new JFrame();
        this.signupButton= new JButton("Sign up");
        this.loginButton=  new JButton("Login");

        this.loginButton.setBounds(50,250, 100, 20);
        this.signupButton.setBounds(200, 250, 100,20);
        this.loginButton.addActionListener(this);
        this.signupButton.addActionListener(this);

        this.frame.setLayout(null);
        this.frame.add(loginButton);
        this.frame.add(signupButton);

        this.frame.setVisible(true);

        this.frame.setSize(500,500);



    }

    public static void main(String[] args) {
        new StartMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.signupButton){
            this.frame.dispose();
            SignupMenu signupMenu = new SignupMenu();
        }else if(e.getSource() == this.loginButton){
            this.frame.dispose();
            LoginMenu loginMenu = new LoginMenu();

        }
    }
}
