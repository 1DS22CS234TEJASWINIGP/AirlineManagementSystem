package airlinemanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public UserLogin() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLoginButtonClicked();
            }
        });
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 80, 80, 25);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegisterButtonClicked();
            }
        });
        panel.add(registerButton);
    }

    private void onLoginButtonClicked() {
        try{
Class.forName("com.mysql.cj.jdbc.Driver");
String un  = usernameField.getText();
String pw = passwordField.getText();

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams?useSSL=false", "root", "29032005@Teju");
Statement st= con.createStatement();
//String sql = "Select username,password from Register;
ResultSet rs = st.executeQuery("Select username,password from Register WHERE username='"+un+"' AND password='"+pw+"'");
if(rs.next()){
String username = rs.getString("username");
String password = rs.getString("password");

//if(un.equals(username) && pw.equals(password)){
  JOptionPane.showMessageDialog(this, "Login Successful");  
  new TicketDashboard1().setVisible(true);
}
else
{
    JOptionPane.showMessageDialog(this, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
}

}
catch(Exception e){
JOptionPane.showMessageDialog(this, "Error while establishing connection failed!!!");
}
 
    }

    private void onRegisterButtonClicked() {
        
        try{
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "29032005@Teju");
String sql = "insert into register values (?,?)";
PreparedStatement ptst= con.prepareStatement(sql);
ptst.setString(1,usernameField.getText());
ptst.setString(2,String.valueOf(passwordField.getPassword()));
ptst.executeUpdate();
JOptionPane.showMessageDialog(this, "Registration Succesfull!");
con.close();
}
catch(Exception e){
}

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLogin());
    }
}