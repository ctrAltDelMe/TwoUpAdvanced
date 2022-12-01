//import javax.swing.Icon;
//import javax.swing.JLabel;

public class RandomiseCoinFlip{

	static String coinResult;
	///// Image Variable to Set /////
	static String gifImageResult;
	static String resultText;
	
	public static String CoinFlip() {

		////Generate a random number ////
				int min = 1;
				int max = 3;
				int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
					switch(random_int) {
					case 1:
						coinResult = "hh";
						gifImageResult = "hh";
						System.out.println("The result was heads/heads");
						break;
					case 2:
						coinResult = "ht";
						gifImageResult = "ht";
						System.out.println("The result was heads/tails");

						break;
					case 3:
						coinResult = "tt";
						gifImageResult = "tt";
						System.out.println("The result was tails/tails");

						break;
					}
					String coinChoiceSelect = Gui.coinChoice.getSelection().getActionCommand();
					
					if(coinChoiceSelect == coinResult) {
						System.out.println("win!");
						resultText ="You Win";
						Gui.flipResult.setText(resultText);
						calcScore();
						System.out.println(Gui.score);
					}else {
						System.out.println("Lose!");
						resultText ="You Lose";
						Gui.flipResult.setText(resultText);
						calcScore();
						System.out.println(Gui.score);
					}
					return coinResult;
		}
	
	public static void calcScore() {
		String stringToConvert;
		Integer convertedString;
		stringToConvert = getString(Gui.score);
		convertedString = Integer.parseInt(stringToConvert);
		
			if(resultText == "You Win") {
				convertedString = convertedString + 1;
				stringToConvert = Integer.toString(convertedString);
				Gui.score = stringToConvert;
				Gui.sessionScore.setText(Gui.score);
				///// Ensure that nothing is taken if score is zero ////
			}if(resultText == "You Lose" && convertedString != 0) {
				convertedString = convertedString - 1;
				stringToConvert = Integer.toString(convertedString);
				Gui.score = stringToConvert;
				Gui.sessionScore.setText(Gui.score);
			} else {}
	}	


	private static String getString(String score) {
		// TODO Auto-generated method stub
		return Gui.score;
	}
}
	

	
	

