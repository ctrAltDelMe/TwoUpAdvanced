
public class ApplicationController extends App {
	
	static String coinResult = "";
	
	public static void Coins() {
		RandomiseCoinFlip.CoinFlip();
		System.out.println("Your coin flip Result is: " + coinResult);
	}
	
	public static String GifConversion(String gifResult) {
		gifResult = coinResult + ".gif";
		System.out.println("The image file is: " + gifResult);
		return gifResult;
		
	}




	
}
