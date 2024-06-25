import java.util.Random;

public class Deck {
	// Data Members
		private Card deck[] = new Card[52];
		private int top = 0;
		
		// Constructor
		public Deck() {
			int pos = 0;
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 13; j++) {
					String suit = "";
					String value = "";

					if (i == 0)
						suit = "H";
					else if (i == 1)
						suit = "D";
					else if (i == 2)
						suit = "C";
					else if (i == 3)
						suit = "S";

					if (j == 0)
						value = "A";
					else if (j == 10)
						value = "J";
					else if (j == 11)
						value = "Q";
					else if (j == 12)
						value = "K";
					else
						value = "" + (j + 1);

					deck[pos] = new Card(value, suit);
					pos++;
				}
		}

		// Prints the contents of the deck.
		public void PrintDeck() {
			for (int i = 0; i < deck.length; i++) {
				System.out.print(deck[i].toString(false) + " ");
			}
			System.out.println();
		}

		// Makes a copy of the deck.
		public Deck copyDeck() {
			Deck tempdeck = new Deck();

			for (int i = 0; i < 52; i++) {
				tempdeck.deck[i] = new Card(deck[i].getValue(), deck[i].getSuit());
			}

			return tempdeck;
		}

		// Simulates a non-perfect Riffle Shuffle of the Deck.
		public void RiffleShuffleDeck() {
			Random generator = new Random();
			Card tempdeck[] = new Card[deck.length];

			for (int i = 0; i < 7; i++) {
				int tempdeckpos = 0;
				int mid = deck.length / 2;
				int start = 0;

				while (tempdeckpos < deck.length) {
					int side = generator.nextInt(2);

					if (side == 0) {
						int skip1 = generator.nextInt(3) + 1;
						if (start < deck.length / 2) {
							if (start + skip1 > deck.length / 2)
								skip1 = deck.length / 2 - start;

							for (int j = start; j < start + skip1; j++) {
								tempdeck[tempdeckpos] = deck[j];
								tempdeckpos++;
							}
						}
						start += skip1;
					} else {
						int skip2 = generator.nextInt(3) + 1;
						if (mid < deck.length) {
							if (mid + skip2 > deck.length)
								skip2 = deck.length - mid;

							for (int j = mid; j < mid + skip2; j++) {
								tempdeck[tempdeckpos] = deck[j];
								tempdeckpos++;
							}
						}
						mid += skip2;
					}
				}

				for (int j = 0; j < deck.length; j++)
					deck[j] = tempdeck[j];
			}
			top = 0;
		}

		// Simulates an interchange shuffle of the deck.
		public void InterchangeShuffleDeck() {
			Random generator = new Random();

			for (int i = 0; i < 3000; i++) {
				int card1 = generator.nextInt(52);
				int card2 = generator.nextInt(52);
				Card tempcard = deck[card1];
				deck[card1] = deck[card2];
				deck[card2] = tempcard;
			}
			top = 0;
		}

		// Calls one of the two shuffle algorithms.
		public void ShuffleDeck() {
			InterchangeShuffleDeck();
			// RiffleShuffleDeck();
		}

		// Simulates dealing a card off the deck.
		public Card dealCard() {
			return deck[top++];
		}

		// Resets the top of the deck.
		public void resetTop() {
			top = 0;
		}
		
		
}

