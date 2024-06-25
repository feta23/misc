
public class highlowgame {

	public static String CardString(int face, int suit) {

		String suit1 = "";

		if (suit == 1)
			suit1 = "Spades";
		if (suit == 2)
			suit1 = "Clubs";
		if (suit == 3)
			suit1 = "Diamonds";
		if (suit == 4)
			suit1 = "Hearts";
//---------------------------
		String Ace = "Ace of ";
		String Jack = "Jack of ";
		String Queen = "Queen of ";
		String King = "King of ";
//---------------------------------		

//return
		if (face == 14)
			return Ace + suit1;
		if (face == 11)
			return Jack + suit1;
		if (face == 12)
			return Queen + suit1;
		if (face == 13)
			return King + suit1;
		else
			return Integer.toString(face) + " of " + suit1;

	}

	public static int getCardFace() {
		int c = (int) (Math.random() * 14) + 2;
		return c;
	}

	public static int getCardSuit() {
		int c = (int) (Math.random() * 4) + 1;
		return c;

	}

public static int Winner(int p1f, int p1s, int p2f, int p2s){
	
	//Spades winning over Clubs which wins over Diamonds which wins over Hearts.
if(p1f>p2f)
	return 1;
if(p1f<p2f)
	return 2;
else {
	if(p1s>p2s)
		return 1;
	if(p1s<p2s)
		return 2;
	else 
		return 0;
}
	


	
	
	
}

	public static void main(String[] args) {
		int player1CardFace = getCardFace();
		int player1CardSuit = getCardSuit();
		int player2CardFace = getCardFace();
		int player2CardSuit = getCardSuit();
		System.out.println("Player 1: " + CardString(player1CardFace, player1CardSuit));
		System.out.println("Player 2: " + CardString(player2CardFace, player2CardSuit));
		int win = Winner(player1CardFace, player1CardSuit, player2CardFace, player2CardSuit);
		if (win == 1)
			System.out.println("Player 1 Wins");
		else if (win == 2)
			System.out.println("Player 2 Wins");
		else
			System.out.println("It is a draw.");
	}

}
