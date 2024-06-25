import java.util.Scanner;

public class fizzbinFinalVersion {
	
	/*
	 *George Fotiou
	 *4/6/2020
	 *This program simulates the game a two player Fizzbin game
	 */
	
	public static String newroll() {
		int dieroll = (int) (Math.random() * 20) + 1;
		return "New roll: " + dieroll;
	}
	
		
	public static String newcard() {
		
		int cardnumber = (int) (Math.random() * 14) + 1;
		int score = 0;
//------------Score
		if (cardnumber > 11)
			score = score + 12;
		if (cardnumber == 11)
			score = score + 15;
		else
			score = score + cardnumber;

		// for the suit
		int x = (int) (Math.random() * 4) + 1;

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

	return   cardnumber + " of " + suit1; 
	}
	
//===================================================================	
	public static String player2() {

		int dieroll = (int) (Math.random() * 20) + 1;
		int score = 0 + dieroll;
		int cardnumber = (int) (Math.random() * 14) + 1;
//------------Score
		if (cardnumber > 11)
			score = score + 12;
		if (cardnumber == 11)
			score = score + 15;
		else
			score = score + cardnumber;

		// for the suit
		int x = (int) (Math.random() * 4) + 1;

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
		String wuh = "Player2: ";

//return
		if (cardnumber == 11)
			return wuh + Ace + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		if (cardnumber == 12)
			return wuh + Jack + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		if (cardnumber == 13)
			return wuh + Queen + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		if (cardnumber == 14)
			return wuh + King + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		else
			return wuh + cardnumber + " of " + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;

	}

	public static String player1() {
		
		int dieroll = (int) (Math.random() * 20) + 1;
		int score = 0 + dieroll;
		int cardnumber = (int) (Math.random() * 14) + 1;
//------------Score
		if (cardnumber > 11)
			score = score + 12;
		if (cardnumber == 11)
			score = score + 15;
		else
			score = score + cardnumber;

		// for the suit
		int x = (int) (Math.random() * 4) + 1;
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
			return wuh + Ace + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		if (cardnumber == 12)
			return wuh + Jack + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		if (cardnumber == 13)
			return wuh + Queen + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		if (cardnumber == 14)
			return wuh + King + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;
		else
			return wuh + cardnumber + " of " + suit1 + "   Die Roll: " + dieroll + "   Score: " + score;	
	}
//=====================================================
	public static String newcardandroll() {
		Scanner kbd = new Scanner (System.in);
	
		System.out.println("");
		int gg = 1; 
		
		do {
		String answer;
		
		System.out.print("Do you want a new card? (y/n):");
		answer = kbd.nextLine().trim().toLowerCase();
		
		if(answer.contains("y")) {
			System.out.println(newcard());
			++gg;
		}
			else if(answer.contains("n")) {
				break;
		}
			else {
				System.out.println("Not a valid input");
			}
		}while(gg==1);		
		
//------------------
	int gh = 1;
		do {
			
		
		String answer2;
		System.out.print("Do you want a new roll? (y/n):");
		answer2 = kbd.nextLine().trim().toLowerCase();
		
		if(answer2.contains("y")) {
			System.out.println( newroll() );
			System.out.println("");
			++gh;
		}
			else if(answer2.contains("n")) {
			
				break;
		}
			else {
				System.out.println("Not a valid input");
			}
		}while(gh==1);				
		
		return "";
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int round = 1;

		do {

			System.out.println("");
			System.out.println("Round " + round);
			System.out.println("================");
			System.out.println(player1());
			System.out.println(player2());
			System.out.println("");
			System.out.print("Player1:");
			System.out.print(newcardandroll());
			System.out.println("");
			System.out.print("Player2:");
			System.out.print(newcardandroll());
			

			++round;
		} while (round != 11);
	}
	
}

