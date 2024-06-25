import java.util.Random;
import java.util.Scanner;

public class question3 {
	/*
	 * George Fotiou
	 * 4/21/20
	 * This program takes input of array size, max entry size, and count division to
	 * give properties of the array
	 */
	
	
	
	public static void PopulateArray(int[] A, int n) {

		for (int i = 0; i < A.length; ++i) {
			A[i] = (int) (Math.random() * n) + 1;
		}
	}

	public static void PrintArray(int[] Arr, int width) {
		String decimal = "%" + width + "d";
		for (int i = 0; i < Arr.length; i++) {
			System.out.printf(decimal, Arr[i]);
		}
		System.out.println();
	}

	public static void PrintArrayBarChart(int Arr[]) {

		for (int i = 0; i < Arr.length; ++i) {
			for (int j = 1; j <= Arr[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static int SumArray(int[] A) {

		int sum = 0;
		for (int i = 0; i < A.length; ++i) {
			sum += A[i];
		}
		return sum;
	}

	public static int AvgArray(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; ++i) {
			sum += A[i];
		}
		int avg = sum/A.length;
		return avg;
	}

	public static double VarianceArray(int[] A) {
		double var = 0.0;
		if (A.length < 2) {
			return 0;
		} else {
			for (int i = 1; i < A.length; ++i) {
				var = SumArray(A) * (((A[i] - AvgArray(A)) * (A[i] - AvgArray(A))) / (A.length - 1.0));
			}
		}
		return var;
	}

	public static double StandardDeviationArray(int[] A) {
		double stdDev = 0.0;
		double variance = VarianceArray(A); 
		if (A.length <= 2) {
			return 0;
		} else {
			stdDev = Math.sqrt(variance);
		}
		return stdDev;
	}

	public static int MaxArray(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		return max;
	}

	public static int MinArray(int[] A) {
		int min = MaxArray(A);
		for (int i = 0; i < A.length; ++i) {
			if (A[i]<min) {
				min = A[i];
			}
		}
		return min;
	}

	public static int CountLessArray(int[] A, int n) {
		int count = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] < n) {
				++count;
			}
		}
		return count;
	}

	public static int CountGreaterArray(int[] A, int n) {

		int count = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] > n) {
				++count;
			}
		}
		return count;

	}

	public static int[] ReverseArray(int[] A) {

		int ArrayReverse[] = new int[A.length];

		for (int i = 0; i < A.length; ++i) {
			ArrayReverse[i] = A[A.length - 1 - i];
		}
		return ArrayReverse;
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input the array size: ");
		int arraySize = keyboard.nextInt();
		System.out.print("Input max entry size: ");
		int entrysize = keyboard.nextInt();
		System.out.print("Input the count division: ");
		int countdiv = keyboard.nextInt();
		int intArray[] = new int[arraySize];
		PopulateArray(intArray, entrysize);
		PrintArray(intArray, 4);
		System.out.println("The sum of the array is = " + SumArray(intArray));
		System.out.println("The average of the array is = " + AvgArray(intArray));
		System.out.println("The maximum of the array is = " + MaxArray(intArray));
		System.out.println("The minimum of the array is = " + MinArray(intArray));
		System.out.println(
				"The number less than " + countdiv + " in the array is = " + CountLessArray(intArray, countdiv));
		System.out.println(
				"The number greater than " + countdiv + " in the array is = " + CountGreaterArray(intArray, countdiv));
		System.out.println("The variance of the array is = " + VarianceArray(intArray));
		System.out.println("The standard deviation of the array is = " + StandardDeviationArray(intArray));
		System.out.println();
		PrintArrayBarChart(intArray);
		System.out.println();
		int[] B = ReverseArray(intArray);
		PrintArray(intArray, 4);
		PrintArray(B, 4);
	}

}
