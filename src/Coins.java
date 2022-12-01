import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Coins {
	
	String imageHT = "ht.gif";
	String imageHH = "hh.gif";
	String imageTT = "tt.gif";
	
	public void Coins() {
		JFrame coinFrame = new JFrame();
		coinFrame.setTitle("Coin Result");
		coinFrame.setLayout(new FlowLayout());
		coinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  
		if(RandomiseCoinFlip.gifImageResult == "hh") {
			Icon imgIcon = new ImageIcon(this.getClass().getResource(imageHH));
			  JLabel label = new JLabel(imgIcon);
			  coinFrame.add(label);
		}
		if(RandomiseCoinFlip.gifImageResult == "ht") {
			Icon imgIcon = new ImageIcon(this.getClass().getResource(imageHT));
			  JLabel label = new JLabel(imgIcon);
			  coinFrame.add(label);
		}
		if (RandomiseCoinFlip.gifImageResult == "tt"){
			Icon imgIcon = new ImageIcon(this.getClass().getResource(imageTT));
			  JLabel label = new JLabel(imgIcon);
			  coinFrame.add(label);
		}
		  coinFrame.pack();
		  coinFrame.setVisible(true);
		  new Timer(3_000, (e)-> {coinFrame.setVisible(false); coinFrame.dispose(); }).start();
	}

}
