import java.util.ArrayList;

/*
 * George Fotiou
 * 5/5/2020
 * This program simulates the card game of War. 
 */

public class GameOfWar {
	public static void main(String[] args) {
		boolean draw = false;
		// boolean for the do while loop when there is a draw
		int round = 1;
		// round counter
		int end = 0;
		// for the for loop

		ArrayList<Card> Hand1 = new ArrayList<Card>();
		ArrayList<Card> Hand2 = new ArrayList<Card>();
		ArrayList<Card> temp = new ArrayList<Card>();

		Deck cards = new Deck();
		cards.ShuffleDeck();

		for (int i = 0; i < 26; ++i) {
			Hand1.add(cards.dealCard());
			Hand2.add(cards.dealCard());
		}

		for (end = 0; end < 1;) {
			// for loop to keep the game running

			System.out.println("");
			System.out.print("Round " + round); 
			// prints the round number
			System.out.println();
			System.out.print("Player1 :"); 
			// player1's cards are printed
			System.out.print(Hand1);
			System.out.println();
			System.out.print("Player2 :");
			// player2's cards are printed
			System.out.print(Hand2);
			System.out.println("");

			if (Hand1.get(0).getWorth() > Hand2.get(0).getWorth()) { 
				// if player1's card wins
				temp.add(Hand1.get(0));
				// first card is added to the temp deck
				Hand1.remove(0); 
				// first card is removed from the front of the deck
				Hand1.add(temp.get(0)); 
				// first card gets added back to the player1's deck from the temp deck
				Hand1.add(Hand2.get(0)); 
				// player1 also gets player2's card that they played and is added BEHIND the
				// card player1 played.
				Hand2.remove(0); 
				// player2's card is removed from their deck
				temp.clear(); 
				// clears the temporary deck

//if hand1(0) is greater than hand2(0), hand1(0) gets added to the temp slot, then added back to 
//the end of the array, then adds hand2's card that was won
			}
			if (Hand1.get(0).getWorth() < Hand2.get(0).getWorth()) { // if player2's card wins the round
				temp.add(Hand2.get(0)); 
				// first card is added to the temp deck
				Hand2.remove(0); 
				// the first card is removed from the front of the deck
				Hand2.add(temp.get(0)); 
				// the fist card is then added back to to player2's deck, from the temp deck
				Hand2.add(Hand1.get(0)); 
				// player2 gets player1's card added to the back of their deck
				Hand1.remove(0); 
				// player1's card is removed from their deck
				temp.clear(); 
				// temp deck is cleared
//if hand2(0) is greater than hand1(0), hand2(0) gets added to the temp slot, then added back to 
//the end of the array, then adds hand1's card that was won
			} else if (Hand1.get(0).getWorth() == Hand2.get(0).getWorth()) { 
				// if two cards are equal value, draw is set back to false
				draw = false; 
				// used for the do while loop if there is a draw. Do while runs while draw is FALSE

				do {
					if (Hand1.get(0).getWorth() == Hand2.get(0).getWorth()) {
//if two cards are equal, first it will check if there are enough cards in both players decks to start a war. 
//if there are not enough cards to continue the war, the game is over and the other player takes all the cards 
						if (Hand1.size() == 0 || Hand1.size() < 3 || Hand2.size() == 0 || Hand2.size() < 3) {

							if (Hand1.size() == 0) { 
								// once a hand size gets to 0 the game is over.
								++end;
								draw = true;
								System.out.println("Round " + round);
								System.out.println("");
								System.out.print("Player1: Out of Cards! ");
								System.out.println("");
								System.out.print("Player2: " + Hand2);
								System.out.println("");
								System.out.print("Player2 Wins!");
								System.exit(0);
							}
							if (Hand1.size() < 3) { 
								// if a player has less than 3 cards when there is a war, the player automatically loses and all their cards are added to theopposition
								draw = true; 
								// breaks the do while loop
								for (int i = 0; i < Hand1.size(); ++i) {
									Hand2.add(Hand1.get(i));
									// adds the cards to the winners deck
								}
								if (Hand2.size() < 3) {
									draw = true;
									for (int i = 0; i < Hand2.size(); ++i) {
										Hand1.add(Hand2.get(i));
									}
									if (Hand2.size() == 0) {
										++end;
										draw = true;
										System.out.println("Round " + round);
										System.out.println("");
										System.out.print("Player1: " + Hand1);
										System.out.println("");
										System.out.print("Player2: Out of Cards!");
										System.out.println("");
										System.out.print("Player1 Wins!");
										System.exit(0);
									}
								}
							}
						}

						if (Hand1.size() < 3 || Hand2.size() < 3 || Hand2.size() == 0 || Hand2.size() < 3) {
							++end;
							draw = true;

							if (Hand1.size() < 3 && Hand1.size() > 0) {
								for (int i = 0; i < Hand1.size(); ++i) {
									Hand2.add(Hand1.get(0));
									Hand1.remove(0);
								}
								System.out.println("Round " + round);
								System.out.println("");
								System.out.print("Player1: Out of Cards! ");
								System.out.println("");
								System.out.print("Player2: " + Hand2);
								System.out.println("");
								System.out.print("Player2 Wins!");
								System.exit(0);
							}
							if (Hand2.size() < 3 && Hand2.size() > 0) {
								++end;
								draw = true;
								for (int i = 0; i < Hand2.size(); ++i) {
									Hand1.add(Hand2.get(0));
									Hand2.remove(0);

								}
								System.out.println("Round " + round);
								System.out.println("");
								System.out.print("Player1: " + Hand1);
								System.out.println("");
								System.out.print("Player2: Out of Cards!");
								System.out.println("");
								System.out.print("Player1 Wins!");
								System.exit(0);

							}
						}

					}
					// when there is a draw, each player has to draw to cards and compare the values
					// of the new ones

					temp.add(Hand1.get(0));
					// original card
					Hand1.remove(0);

					temp.add(Hand2.get(0));
					// original card
					Hand2.remove(0);
					

					temp.add(Hand1.get(0));
					// new two cards
					Hand1.remove(0);
					temp.add(Hand1.get(0));
					Hand1.remove(0);

					temp.add(Hand2.get(0));
					Hand2.remove(0);
					temp.add(Hand2.get(0));
					Hand2.remove(0);
					// new two cards

					if (Hand1.get(0).getWorth() > Hand2.get(0).getWorth()) {
						// if player1's card is greater, the cards are added to their deck

						for (int i = 0; i < temp.size();) {

							Hand1.add(temp.get(0));
							temp.remove(0);

						}
						draw = true;
					}
					if (Hand1.get(0).getWorth() < Hand2.get(0).getWorth()) {
						// if player2's card is greater, the cards are added to their deck

						for (int i = 0; i < temp.size();) {

							Hand2.add(temp.get(0));
							temp.remove(0);
						}
						draw = true;
					}
				} while (draw = false);
			}
			++round;
		}
		// end of for loop to keep game running
	}
}
