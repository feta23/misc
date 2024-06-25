
public class Card {	
	// Data Members
		private String value;
		private String suit;

		// Constructor
		public Card(String v, String s) {
			value = v;
			suit = s;
		}

		public String getValue() {
			return value;
		}

		public String getSuit() {
			return suit;
		}

		// Determine face value.
		public int getWorth() {
			if (value.equals("A"))
				return 1;
			else if (value.equals("2"))
				return 2;
			else if (value.equals("3"))
				return 3;
			else if (value.equals("4"))
				return 4;
			else if (value.equals("5"))
				return 5;
			else if (value.equals("6"))
				return 6;
			else if (value.equals("7"))
				return 7;
			else if (value.equals("8"))
				return 8;
			else if (value.equals("9"))
				return 9;
			else
				return 10;
		}

		// Determine face value, with variable ace.
		public int getWorth(int ace) {
			if (value.equals("A"))
				return ace;
			else if (value.equals("2"))
				return 2;
			else if (value.equals("3"))
				return 3;
			else if (value.equals("4"))
				return 4;
			else if (value.equals("5"))
				return 5;
			else if (value.equals("6"))
				return 6;
			else if (value.equals("7"))
				return 7;
			else if (value.equals("8"))
				return 8;
			else if (value.equals("9"))
				return 9;
			else
				return 10;
		}

		// Determine if an ace.
		public boolean isAce() {
			return value.equals("A");
		}

		// Check equality of two cards.
		public boolean equals(Card card2) {
			return value.equals(card2.getValue()) && suit.equals(card2.getSuit());
		}

		// String output of card.
		public String toString() {
			return value + " " + suit;
		}

		// String output of card, with or without a space.
		public String toString(boolean space) {
			String retstr = value;
			if (space)
				retstr += " ";
			retstr += suit;
			return retstr;
		}
}