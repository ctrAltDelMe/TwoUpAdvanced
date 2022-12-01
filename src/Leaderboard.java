import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Leaderboard extends JTable{
	
	static DefaultTableModel defaultTableModel;
	
	static JTable table;
	
	public static Component Leaderboard() {


		
		defaultTableModel = new DefaultTableModel();
		table = new JTable(defaultTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(10,10));
		table.setFillsViewportHeight(true);
		defaultTableModel.addColumn("Username");
		defaultTableModel.addColumn("Score");
		
		try {
			Connection myConn = DriverManager.getConnection(DatabaseManager.DB_URL, DatabaseManager.USER, DatabaseManager.PASS);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT users.UserName, scores.Score FROM scores INNER JOIN users ON scores.unameId = users.Personid ORDER BY Score DESC LIMIT 10");
						
			while(myRs.next()) {
				String name = myRs.getString("UserName");
				String score = myRs.getString("Score");
				defaultTableModel.addRow(new Object[] {name, score});
				
			}

	}
	 catch (SQLException throwables) {
          throwables.printStackTrace();
      }
		return table;

	}

	
}



