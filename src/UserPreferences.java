import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPreferences extends Gui{
	
	private static JComboBox colourCombo;
	private static JComboBox fontCombo;
	
	public static void UserPrefPopup() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JFrame frame = new JFrame();
		frame.setTitle("User Preferences");
		frame.add(panel);
		frame.setBounds(500, 100, 400, 350);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel colourLabel = new JLabel("Select your Colour Scheme");
		colourLabel.setBounds(100, 25, 180, 25);
		panel.add(colourLabel);
		
		String[] colourItems = {"black", "blue", "green"};
		
		JComboBox colourCombo = new JComboBox(colourItems);
		colourCombo.setSelectedIndex(0);
		colourCombo.setEditable(false);
		colourCombo.setBounds(100, 50, 180, 25);
		panel.add(colourCombo);
		
		JLabel fontLabel = new JLabel("Select your font");
		fontLabel.setBounds(100, 100, 180, 25);
		panel.add(fontLabel);
		
		String[] fontItems = {"Times New Roman", "Calibri"};
		
		JComboBox fontCombo = new JComboBox(fontItems);
		fontCombo.setSelectedIndex(0);
		fontCombo.setEditable(false);
		fontCombo.setBounds(100, 125, 180, 25);
		panel.add(fontCombo);
		
		JButton applyChangeBtn = new JButton("Apply Changes");
		applyChangeBtn.setBounds(100,200,180,25);
		applyChangeBtn.setForeground(Color.WHITE);
		applyChangeBtn.setBackground(Color.black);
		panel.add(applyChangeBtn);
		
		frame.setVisible(true);
		
		applyChangeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//System.out.println("Colour Selected: " + colourCombo.getSelectedItem().toString());
				//System.out.println("Font Selected: " + fontCombo.getSelectedItem().toString());
				
				String colourChoice = colourCombo.getSelectedItem().toString();
				
				
				if(colourChoice == "black") {
					Gui.panel.setBackground(Color.BLACK);
					Gui.panel.setForeground(Color.WHITE);
					Gui.flipResult.setForeground(Color.WHITE);
					Gui.guessTitle.setForeground(Color.WHITE);
					Gui.leaderboardLabel.setForeground(Color.WHITE);
					Gui.sessionScore.setForeground(Color.WHITE);
					Gui.sessionScoreLabel.setForeground(Color.WHITE);
					Gui.userLabel.setForeground(Color.WHITE);
					Gui.usertextLabel.setForeground(Color.WHITE);
					
					Gui.exitBtn.setBackground(Color.WHITE);
					Gui.exitBtn.setForeground(Color.BLACK);
					Gui.flipCoins.setBackground(Color.WHITE);
					Gui.flipCoins.setForeground(Color.BLACK);
					Gui.loginBtn.setBackground(Color.WHITE);
					Gui.loginBtn.setForeground(Color.BLACK);
					Gui.registerBtn.setBackground(Color.WHITE);
					Gui.registerBtn.setForeground(Color.BLACK);
					Gui.userPrefBtn.setBackground(Color.WHITE);
					Gui.userPrefBtn.setForeground(Color.BLACK);
					
					Gui.headsHeads.setBackground(Color.BLACK);
					Gui.headsHeads.setForeground(Color.WHITE);
					Gui.headsTails.setBackground(Color.BLACK);
					Gui.headsTails.setForeground(Color.WHITE);
					Gui.tailsTails.setBackground(Color.BLACK);
					Gui.tailsTails.setForeground(Color.WHITE);
					
					
					//System.out.print(Gui.panel.getForeground());

				} if(colourChoice == "blue") {
					Gui.panel.setBackground(Color.BLUE);
					Gui.panel.setForeground(Color.WHITE);
					Gui.flipResult.setForeground(Color.WHITE);
					Gui.guessTitle.setForeground(Color.WHITE);
					Gui.leaderboardLabel.setForeground(Color.WHITE);
					Gui.sessionScore.setForeground(Color.WHITE);
					Gui.sessionScoreLabel.setForeground(Color.WHITE);
					Gui.userLabel.setForeground(Color.WHITE);
					Gui.usertextLabel.setForeground(Color.WHITE);
					
					Gui.exitBtn.setBackground(Color.WHITE);
					Gui.exitBtn.setForeground(Color.BLUE);
					Gui.flipCoins.setBackground(Color.WHITE);
					Gui.flipCoins.setForeground(Color.BLUE);
					Gui.loginBtn.setBackground(Color.WHITE);
					Gui.loginBtn.setForeground(Color.BLUE);
					Gui.registerBtn.setBackground(Color.WHITE);
					Gui.registerBtn.setForeground(Color.BLUE);
					Gui.userPrefBtn.setBackground(Color.WHITE);
					Gui.userPrefBtn.setForeground(Color.BLUE);
					
					Gui.headsHeads.setBackground(Color.BLUE);
					Gui.headsHeads.setForeground(Color.WHITE);
					Gui.headsTails.setBackground(Color.BLUE);
					Gui.headsTails.setForeground(Color.WHITE);
					Gui.tailsTails.setBackground(Color.BLUE);
					Gui.tailsTails.setForeground(Color.WHITE);
					
				} else if(colourChoice == "green") {
					Gui.panel.setBackground(Color.GREEN);
					Gui.flipResult.setForeground(Color.BLACK);
					Gui.guessTitle.setForeground(Color.BLACK);
					Gui.leaderboardLabel.setForeground(Color.BLACK);
					Gui.sessionScore.setForeground(Color.BLACK);
					Gui.sessionScoreLabel.setForeground(Color.BLACK);
					Gui.userLabel.setForeground(Color.BLACK);
					Gui.usertextLabel.setForeground(Color.BLACK);
					
					Gui.exitBtn.setBackground(Color.WHITE);
					Gui.exitBtn.setForeground(Color.BLACK);
					Gui.flipCoins.setBackground(Color.WHITE);
					Gui.flipCoins.setForeground(Color.BLACK);
					Gui.loginBtn.setBackground(Color.WHITE);
					Gui.loginBtn.setForeground(Color.BLACK);
					Gui.registerBtn.setBackground(Color.WHITE);
					Gui.registerBtn.setForeground(Color.BLACK);
					Gui.userPrefBtn.setBackground(Color.WHITE);
					Gui.userPrefBtn.setForeground(Color.BLACK);
					
					Gui.headsHeads.setBackground(Color.GREEN);
					Gui.headsHeads.setForeground(Color.BLACK);
					Gui.headsTails.setBackground(Color.GREEN);
					Gui.headsTails.setForeground(Color.BLACK);
					Gui.tailsTails.setBackground(Color.GREEN);
					Gui.tailsTails.setForeground(Color.BLACK);
				}
				
				String fontChoice = fontCombo.getSelectedItem().toString();
					
				if(fontChoice == "Times New Roman") {
					Gui.panel.setFont(new Font("Times New Roman", 0, 14));
					Gui.flipResult.setFont(new Font("Times New Roman", 0, 14));
					Gui.guessTitle.setFont(new Font("Times New Roman", 0, 14));
					Gui.leaderboardLabel.setFont(new Font("Times New Roman", 0, 14));
					Gui.sessionScore.setFont(new Font("Times New Roman", 0, 14));
					Gui.sessionScoreLabel.setFont(new Font("Times New Roman", 0, 14));
					Gui.userLabel.setFont(new Font("Times New Roman", 0, 14));
					Gui.usertextLabel.setFont(new Font("Times New Roman", 0, 14));
					Gui.exitBtn.setFont(new Font("Times New Roman", 0, 14));
					Gui.flipCoins.setFont(new Font("Times New Roman", 0, 14));
					Gui.loginBtn.setFont(new Font("Times New Roman", 0, 14));
					Gui.registerBtn.setFont(new Font("Times New Roman", 0, 14));
					Gui.userPrefBtn.setFont(new Font("Times New Roman", 0, 14));
					Gui.headsHeads.setFont(new Font("Times New Roman", 0, 14));
					Gui.headsTails.setFont(new Font("Times New Roman", 0, 14));
					Gui.tailsTails.setFont(new Font("Times New Roman", 0, 14));
					//Gui.table.setFont(new Font("Times New Roman", 0, 14));
				}else {
					Gui.panel.setFont(new Font("Calibri", 0, 12));
					Gui.flipResult.setFont(new Font("Calibri", 0, 12));
					Gui.guessTitle.setFont(new Font("Calibri", 0, 12));
					Gui.leaderboardLabel.setFont(new Font("Calibri", 0, 12));
					Gui.sessionScore.setFont(new Font("Calibri", 0, 12));
					Gui.sessionScoreLabel.setFont(new Font("Calibri", 0, 12));
					Gui.userLabel.setFont(new Font("Calibri", 0, 12));
					Gui.usertextLabel.setFont(new Font("Calibri", 0, 12));
					Gui.exitBtn.setFont(new Font("Calibri", 0, 12));
					Gui.flipCoins.setFont(new Font("Calibri", 0, 12));
					Gui.loginBtn.setFont(new Font("Calibri", 0, 12));
					Gui.registerBtn.setFont(new Font("Calibri", 0, 12));
					Gui.userPrefBtn.setFont(new Font("Calibri", 0, 12));
					Gui.headsHeads.setFont(new Font("Calibri", 0, 12));
					Gui.headsTails.setFont(new Font("Calibri", 0, 12));
					Gui.tailsTails.setFont(new Font("Calibri", 0, 12));
				}
				

				
				
			}
			
		});
		
	}
	


}
