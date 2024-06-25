import java.util.ArrayList;

/*
 * George Fotiou
 * 5/7/2020
 *This program calculates the amount of rolls it takes for a six to be rolled 10 times in a row. Also how many 
 *times it was rolled between 1 - 9 in a row.
 */

public class question1 {

	public static int dieRoll() {
		int dieRoll = (int) (Math.random() * 6 + 1);
		// generates a random number between 1-6
		return dieRoll;
	}
	// this method returns a die roll between 1 and 6

	public static void main(String[] args) {

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		int count10 = 0;
//counters to count the lengths of 6's in the die rolls  
		long count = 0;
		// counter for the times six appears 10 times

		ArrayList<Long> A = new ArrayList<Long>();
		// main array list to store die roll simulations in

		do {
			long dieRoll = dieRoll();
			// set dieRoll() method to a variable
			// variable needs to be used for the counter

			A.add(dieRoll);
			// adds that die roll to the array list

			if (dieRoll == 6) {
				// if the roll is 6, the counter will increment
				++count;
			} else {
				// if the roll is not 6, the counter is reset to 0
				count = 0;
			}
		} while (count < 10);
		// do while will populate the array list with the die rolls

		count = 0;
		// count gets reset back to zero to be used in the next block of code

		for (int i = 0; i < A.size(); ++i) {
			// goes through the whole array list. When there is a 6, the counter is
			// incremented. when there
			// isn't a 6, in the else statement, if the count equals 1-9, the counter for
			// that length will increment as well.
			// then count is set back to 0 and the for loop runs again.
			if (A.get(i) == 6) {
				++count;
			} else {
				if (count == 1) {
					++count1;
				} else if (count == 2) {
					++count2;
				} else if (count == 3) {
					++count3;
				} else if (count == 4) {
					++count4;
				} else if (count == 5) {
					++count5;
				} else if (count == 6) {
					++count6;
				} else if (count == 7) {
					++count7;
				} else if (count == 8) {
					++count8;
				} else if (count == 9) {
					++count9;
				}
				count = 0;
			}

		} // end of for loop to count lengths

		System.out.println("Number of Runs Needed: " + A.size());
		System.out.println(" ");
		System.out.println("Runs of Length 1: " + count1);
		System.out.println("Runs of Length 2: " + count2);
		System.out.println("Runs of Length 3: " + count3);
		System.out.println("Runs of Length 4: " + count4);
		System.out.println("Runs of Length 5: " + count5);
		System.out.println("Runs of Length 6: " + count6);
		System.out.println("Runs of Length 7: " + count7);
		System.out.println("Runs of Length 8: " + count8);
		System.out.println("Runs of Length 9: " + count9);
		System.out.println("Runs of Length 10: 1");

	}
}