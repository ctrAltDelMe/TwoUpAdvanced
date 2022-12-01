import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
	
	static JTextField username = new JTextField();
	static JPasswordField password = new JPasswordField();
	static JButton button = new JButton("login");
	
	//DB variables//
	static final String DB_URL = "jdbc:mysql://localhost:3306/two_up";
	static final String USER = "root";
	static final String PASS = "root";
	static final String PASSWORD_QUERY = "SELECT user, password FROM user_name";
	//END OF DB VARIABLES //
	
	public static void LoginPopup() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JFrame frame = new JFrame();
		frame.setTitle("Login Page");
		frame.add(panel);
		frame.setBounds(500, 300, 400, 200);
		
		//frame.setSize(new Dimension(400,200));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel uname = new JLabel("Username");
		uname.setBounds(100,8,70,20);
		panel.add(uname);
		
		username.setBounds(100,27,193,28);
		panel.add(username);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(100,55,70,20);
		panel.add(passwordLabel);
		
		password.setBounds(100,75,193,28);
		panel.add(password);

		button.setBounds(100,110,90,25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.black);
		panel.add(button);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//if(username.getText().isEmpty()){
					//	JOptionPane.showMessageDialog(button, "Please enter a username!");
					
					//}else {
						DatabaseManager.userCheck();
						frame.dispose();
						
					//}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}