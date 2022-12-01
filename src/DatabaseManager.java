import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DatabaseManager {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/two_up";
	static final String USER = "root";
	static final String PASS = "root";
	static final String PASSWORD_QUERY = "SELECT user, password FROM user_name";
	
	public static void userCheck() throws SQLException {

		String userName = Login.username.getText();
		String passWord = Login.password.getText();
		
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM users WHERE UserName = '" + userName +"'");

			
			while(myRs.next()){
				
				if(Login.username.getText().isEmpty()){
					JOptionPane.showMessageDialog(Login.button, "Please enter a username!");
				}
				
				if (userName.contentEquals(myRs.getString("UserName")) && (passWord.contentEquals(myRs.getString("Password")))) {
					System.out.println("Login Successful");
					JOptionPane.showMessageDialog(Login.button, "You have successfully logged in");
					Gui.userLabel.setText("Welcome: " + userName);
					Gui.userName = (userName);
					Gui.headsHeads.setVisible(true);
					Gui.headsTails.setVisible(true);
					Gui.tailsTails.setVisible(true);
					Gui.flipCoins.setVisible(true);
					Gui.userId = myRs.getInt(1);
					Login.username.setText("");
					Login.password.setText("");
					Gui.userNameTest(); // Runs test to see if variables have been updated in GUI

				}
				else {
						System.out.println("Incorrect Username and password");
						JOptionPane.showMessageDialog(Login.button, "Login / Password is not correct!");
						Gui.userLabel.setText("Please Log in");
						Login.username.setText("");
						Login.password.setText("");
			}
			}

			
			}	
		
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}
	
	public static void registerUserCheck() {

		String userName = Register.username.getText();
		String passWord = Register.password.getText();
		
		// Open a connection
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM users WHERE UserName = '" + userName +"'");
			List<String> data = new ArrayList<>();
			while(myRs.next())
			{
				data.add(myRs.getString(2));
			}
			if(data.size() > 0)
			{
				System.out.println("exists");
				JOptionPane.showMessageDialog(Register.button, "User already exists please choose another one!");
			} else {
				System.out.println("does not exist");
				//JOptionPane.showMessageDialog(Register.button, "User added, please login!");
				addUser();
				
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void addUser() {
		String uName = Register.username.getText();
		String pWord = Register.password.getText();
		
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = myConn.createStatement();
			String sql = "INSERT INTO users (UserName, Password) VALUES ('" + uName + "','" + pWord + "')";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(Register.button, "Your username has been successfully registered. Please Login!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	public static void exitProcedure() {

		if(Gui.score == "0") {
			System.out.println("Nothing will be added to database");
			
		} else {
			System.out.println("The following info will be added to the database");
			System.out.println("userId is: " + Gui.userId);
			System.out.println("userName variable equals: " + Gui.userName);
			System.out.println("Final Score is: " + Gui.score);
			try {
				String updateScores = "INSERT INTO scores(unameId, Score) VALUES ('" + Gui.userId + "','" + Gui.score + "')";
				
				Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = myConn.createStatement();
				
				stmt.executeUpdate(updateScores);
				JOptionPane.showMessageDialog(Register.button, "Your score has been saved!");
				
				
			}

				catch (Exception exc) {
					exc.printStackTrace();
			}
			
			
			//// Create script to add info to score table on database
		}
	}
	
	public static void getTopFiveScores() {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT users.UserName, scores.Score FROM scores INNER JOIN users ON scores.unameId = users.Personid ORDER BY Score DESC LIMIT 5");
						
			// process result set
			System.out.println(myRs.toString());
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	}

