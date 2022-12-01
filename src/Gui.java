import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Gui {
	
	///// Image Variable to Set /////

	static String picture = "risingSun.png";
	static String score = "0";
	static String black = "BLACK";
	static String userName; //Variable to store score on exit.
	static int userId;

		JFrame frame = new JFrame("Two up Game");
		static JPanel panel = new JPanel();
		static JButton loginBtn = new JButton("Login");
		static JButton registerBtn = new JButton("Register");
		static JButton userPrefBtn = new JButton("User Preferences");
		static JButton exitBtn = new JButton("Save & Exit");
		static JLabel usertextLabel = new JLabel("Welcome:");
		static JLabel userLabel = new JLabel("User Name Goes Here");
		static JLabel sessionScoreLabel = new JLabel("Your Score is:");
		static JLabel sessionScore = new JLabel("0");
		static JLabel guessTitle = new JLabel("Pick the result: ");
		static ButtonGroup coinChoice = new ButtonGroup();
		static JRadioButton headsHeads = new JRadioButton("Heads / Heads");
		static JRadioButton headsTails = new JRadioButton("Heads / Tails");
		static JRadioButton tailsTails = new JRadioButton("Tails / Tails");
		static JButton flipCoins = new JButton("Flip Coins");
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(picture));
		JLabel image = new JLabel(imgIcon);
		static JTable table;
		static JLabel leaderboardLabel = new JLabel("Leaderboard:");
		static JLabel flipResult = new JLabel("Your result shows here");


		
		public Gui() {
			panel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
			////////!!!!!!!!!///////// CREATE VARIABLE FOR COLOUR //////////////////////
			//panel.setBackground(new Color(186,176,156)); 			//// set background colour ////
			panel.setBackground(Color.WHITE);
			
			///////!!!!!!!!!!//////// CREATE VARIABLE FOR FONT ///////////////////////
			///////!!!!!!!!!!/////// WRITE CODE FOR FONT //////////////////////
			
			
			c.insets = new Insets(5, 5, 5, 5);	// (top, left, right, bottom) //
			
			c.gridx = 0;
			c.gridy = 0;
			panel.add(loginBtn, c);
			
			c.gridx = 1;
			c.gridy = 0;
			panel.add(registerBtn, c);
			
			c.gridx = 2;
			c.gridy = 0;
			panel.add(userPrefBtn, c);
			
			c.gridx = 0;
			c.gridy = 2;
			panel.add(sessionScoreLabel, c);
			
			c.gridx = 0;
			c.gridy = 3;
			panel.add(sessionScore, c);
			
			c.gridx = 0;
			c.gridy = 4;
			panel.add(guessTitle, c);

			//// Add radio buttons to group and assign result values ////
			coinChoice.add(headsHeads);
			headsHeads.setActionCommand("hh");
			coinChoice.add(headsTails);
			headsTails.setActionCommand("ht");
			coinChoice.add(tailsTails);
			tailsTails.setActionCommand("tt");
			
			headsTails.setSelected(true);
			
			c.gridx = 0;
			c.gridy = 5;
			panel.add(headsHeads, c);
			headsHeads.setVisible(false);
			
			c.gridx = 0;
			c.gridy = 6;
			panel.add(headsTails, c);
			headsTails.setVisible(false);
			
			c.gridx = 0;
			c.gridy = 7;
			panel.add(tailsTails, c);
			tailsTails.setVisible(false);
			
			c.gridx = 0;
			c.gridy = 8;
			panel.add(flipCoins, c);
			flipCoins.setVisible(false);
			
			c.gridx = 1;
			c.gridy = 3;
			panel.add(userLabel, c);
			
			c.gridx = 1;
			c.gridy = 4;
			c.gridheight = 5;
			panel.add(image, c);
			
			c.gridx = 2;
			c.gridy = 1;
			panel.add(leaderboardLabel, c);
			
			c.gridx = 2;
			c.gridy = 4;
			panel.add(Leaderboard.Leaderboard(), c);
			
			c.gridx = 2;
			c.gridy = 8;
			panel.add(exitBtn, c);
			
			c.gridx = 1;
			c.gridy = 9;
			panel.add(flipResult, c);
		
			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			frame.setSize(600, 350);
			
			///// Action Listeners /////
			
			flipCoins.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RandomiseCoinFlip.CoinFlip();
					Coins coins = new Coins();
					coins.Coins();
					}
			});
			
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login.LoginPopup();
				}
			});
			
			registerBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Register.RegisterPane();
				}
			});
			
			userPrefBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserPreferences.UserPrefPopup();
				}
			});
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DatabaseManager.exitProcedure();
					System.exit(0);
				}
			});
	}
		public static Component Leaderboard() {

			new FlowLayout();

			String[] columnNames = {"Name", "Score"};
			
			Object[][] data = {
					{"Bill", "5"},
					{"Mary", "4"},
					{"Rick", "3"},
					{"Peter","2"},
					{"Jane","1"},
			};
			
			table = new JTable(data, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(20,20));
			table.setFillsViewportHeight(true);

			return table;
		}
		
		// Test to ensure userName has been set after login. CAN BE DELETED ON CLEANUP //
		public static void userNameTest() {
			System.out.println("userName has been loaded as: " + userName);
			System.out.println("userId has been loaded as: " + userId);
		}
		

		



}