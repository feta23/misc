import java.util.Scanner;

public class question3 {
	public static void main(String[] args) {
		
		/*
		 * George Fotiou
		 * 4/27/2020
		 * This program takes input of number of rows and collums (i know its spelled wrong) and the value of each index of the array. 
		 * It then prints out the original order and then the transposed version
		 */
		
		int n = 0;
		//while loop to keep asking for numbers if of rows and collums are out of bounds (2-5) 
		while (n == 0) {
			Scanner kbd = new Scanner(System.in);
			System.out.print("Enter numbers of rows: ");
			int rows = kbd.nextInt();

			System.out.print("Enter numbers of collums: ");
			int collums = kbd.nextInt();
			if (rows > 1 && rows < 6 && collums > 1 && collums < 6) {
//The array A is made using the variables rows and collums. 
				int A[][] = new int[rows][collums];

				for (int i = 0; i < A.length; i++) {
					for (int j = 0; j < A[0].length; j++) {
						System.out.print("Enter value at row " + (i + 1) + ", collum " + (j + 1) + ":  ");
						A[i][j] = kbd.nextInt();
					}
				}
//regular input being printed
				for (int i = 0; i < A.length; i++) {
					for (int j = 0; j < A[0].length; j++) {
						System.out.printf("%4d", A[i][j]);
					}
					System.out.println(" ");
				}
				System.out.println();
//transpose version being printed
				for (int i = 0; i < A.length; i++) {
					for (int j = 0; j < A[0].length; j++) {
						System.out.printf("%4d", A[j][i]);
					}
					System.out.println(" ");
				}
				++n;
				//ends the while loop 
			} else {
				System.out.println("Please re-enter a number(s) between 2 and 5.");
				System.out.println(" ");
			}
		}
	}

}
