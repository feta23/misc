import java.util.Scanner;

public class question2 {

	
	/*
	 * George Fotiou
	 * 4/21/20
	 * This program takes input of a number and prints an array of the nifty sequence it creates
	 */
	public static int CountEvens(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] % 2 == 0) {
				++count;
			}
		}
		return count;
	}

	public static int CountOdds(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] % 2 != 0) {
				++count;
			}
		}
		return count;
	}
	public static int NiftySequenceLength(int n) {
		int count = 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			++count;
		}
		return count;

	}

	public static void PopulateArray(int[] A) {
		
		
		for(int i = 1; i < A.length; ++i) {
				if (A[i - 1] % 2 == 0) {
					A[i] = A[i - 1] / 2;
				} else {
					A[i] = 3 * A[i - 1] + 1;
				}
				//System.out.println(j);
		} 
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input a number: ");
		int n = keyboard.nextInt();
		int j = NiftySequenceLength(n);
		int Array[] = new int[j];
		Array[0] = n;

		PopulateArray(Array);
		for (int i = 0; i < Array.length; ++i) {
			System.out.print(Array[i] + " ");
		}
		System.out.println();

		System.out.println("Number of Even Numbers in the List: " + CountEvens(Array));
		System.out.println("Number of Odds Numbers in the List: " + CountOdds(Array));

	}

}
