import java.util.Scanner;

public class question1 {
	/*
	 * George Fotiou
	 * 4/27/2020
	 * This program shuffles two decks of cards and determinds if the shuffle was a derangement shuffle or not.  
	 * Prints out derangment count, probability of a derangment, and probability of a derangment over one.
	 */

	//DerangementCheck method
	//Takes in the original and shuffled deck. Each card is compared and 
	//if two cards are in the same index, the trial is not a derangement shuffle. Returns the amount of times 
	//a shuffle was considered deranged
	public static int DerangementCheck(Deck original, Deck shuffled) {
		int count = 0;
		int derCount = 0;
		boolean der = true;
		
		for (int i = 0; i < 52; ++i) {
			Card A = original.dealCard();
			Card B = shuffled.dealCard();
			
			if (A.equals(B)) {
				++count;
			}
			if (count < 1 ) {
				++derCount;
			}
		}
		
		return derCount;
	}
	//trials method
	//Takes in 'a' as the number of trials the user inputs in the main. For each trial two decks are made,
	//one is shuffled the other is not. The decks are both then sent to the DerangementCheck method to 
	//determind the number of derangment shuffles. Prints the derangment count, probability of a derangment,
	//and probability of a derangment over one.  
	public static void trials(int a) {
		int derCount = 0;
		double trials = a; 
		
		for (int i = 0; i <= a; ++i) {
			Deck original = new Deck();
			Deck shuffled = original.copyDeck();
			shuffled.ShuffleDeck();

			System.out.println();
			System.out.print("Original: ");
			original.PrintDeck();

			System.out.print("Shuffled: ");
			shuffled.PrintDeck();
			
			derCount = DerangementCheck(original, shuffled);
			
		}
		System.out.println();
		System.out.println("Derangement Count: " + derCount);
		double probability = (derCount / trials) ;
		System.out.println("Probability of a Derangment: " + probability);
		double probabilityOne = (1.0 / probability) ;
		System.out.print("Probability of a Derangment over 1 : " + probabilityOne);
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int trials = 0;

		for (int j = 0; j < 1;) {
			System.out.print("Input amount of trials (Between 100 and 1,000,000): ");
			trials = kbd.nextInt();

			if (trials < 100 || trials > 1000000) {
				System.out.println("Enter a valid amount");
				System.out.println();
			} else {
				++j;
			}
		}// END OF FIRST FOR LOOP TO GET THE AMOUNT OF TRIALS. If less than 100 or greater than 1 million, will ask for input again.
		
		trials(trials);

	}
}
