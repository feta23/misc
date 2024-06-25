package projectPT2;

public class fizzbinP2 {

	public static String player1() {
		
		int dieroll = (int) (Math.random() * 20) + 1;
		int score = 0 + dieroll;
		int cardnumber = (int) (Math.random() * 14) + 1;
//------------Score
		if (cardnumber <11)
			score = score + 12;
		if (cardnumber == 11)
			 score = score + 15;
		else score = score + cardnumber; 

		// for the suit
		int x = (int) (Math.random() * 4) + 1;

		String S = "Spades";
		String C = "Clubs";
		String D = "Diamonds";
		String H = "Hearts";

		String suit1 = "";

		if (x == 1)
			suit1 = "Spades";
		if (x == 2)
			suit1 = "Clubs";
		if (x == 3)
			suit1 = "Diamonds";
		if (x == 4)
			suit1 = "Hearts";
//---------------------------
		String Ace = "Ace of ";
		String Jack = "Jack of ";
		String Queen = "Queen of ";
		String King = "King of ";
//---------------------------------		
		String wuh = "Player1: ";
		
//return
		if (cardnumber == 11)
			return wuh + Ace + suit1 + "   Die Roll: " + dieroll + "   Score: "+ score;
		if (cardnumber == 12)
			return wuh + Jack + suit1 + "   Die Roll: " + dieroll + "   Score: "+ score;
		if (cardnumber == 13)
			return wuh + Queen + suit1+ "   Die Roll: " + dieroll + "   Score: "+ score;
		if (cardnumber == 14)
			return wuh + King + suit1+ "   Die Roll: " + dieroll + "   Score: "+ score;
		else
			return wuh + cardnumber + " of " + suit1+ "   Die Roll: " + dieroll + "   Score: " + score;

	}

	/*
	 * 
	 * public static int cardvalue1() { int x = (int) (Math.random() * 14) + 1;
	 * return x; }
	 * 
	 * public static String facecard() { String Ace = "Ace of "; String Jack =
	 * "Jack of "; String Queen = "Queen of "; String King = "King of ";
	 * 
	 * if (cardvalue1() == 11) return Ace; else if (cardvalue1() == 12) return Jack;
	 * else if (cardvalue1() == 13) return Queen; else if (cardvalue1() == 14)
	 * return King; else return " Facecard method ";
	 * 
	 * }
	 */
	public static void main(String[] args) {

		int round = 1;

		do {

			System.out.println("");
			System.out.println("Round " + round);
			System.out.println("================");
			System.out.println(player1());

			++round;
		} while (round != 11);

	}

}
