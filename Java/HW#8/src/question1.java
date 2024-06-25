import java.util.Scanner;

public class question1 {
	/*
	 * George Fotiou
	 * 4/21/20
	 * This program takes input of array size and the entries. It then manipulates the 
	 * values and prints them. 
	 */
	
	public static void PrintArray(int[] A, int width) {

		for (int i = 0; i < width; i++) {
			System.out.printf("%5d", A[i]);
		}
	}

	public static void PopulateArray(int[] A) {
		Scanner kbd = new Scanner(System.in);
		for (int i = 0; i < A.length; i++) {
			System.out.print("Input entry: ");
			A[i] = kbd.nextInt();
		}
	}

	public static void ManipulateArray(int[] A) {
		
		for (int i = 0; i < A.length; ++i) {
			if (A[i] % 2 == 0) {
				A[i] = A[i]/2;
			} else if (A[i] % 3 == 0) {
				A[i] =A[i] / 3;
			} else {
				A[i] = A[i] + 5;
			}

		}
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		System.out.print("Input Array Size: ");
		int array_size = kbd.nextInt();
		int Array1[] = new int[array_size];

		PopulateArray(Array1);
		PrintArray(Array1, array_size);

		for (int i = 0; i < 3; ++i) {			
			ManipulateArray(Array1);
			System.out.println();
			PrintArray(Array1, array_size);
		}

	}

}
