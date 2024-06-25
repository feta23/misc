import java.util.Scanner;

public class question4 {
	public static void PrintArray(double A[][], int w, int d) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.printf("%4d", A[i][j]);
			}
			System.out.println(" ");
		}

	}

	public static void populate(double A[][]) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = Math.random() * 100 - 50;
			}
		}
	}

	public static double[][] rowstats(double A[][]) {
		double SUM = 0.0;
		double sum = 0.0;
		double temp = 0.0;
		//row 1 
		for(int i = 0; i < A.length; ++i) {
			for(int j = 0; j < A[0].length; ++j) {
				sum = A[i][j] ;
				
				SUM = sum + temp;
				
			}
		}
		
		
		return (A);
	}

	public static double[][] ColMaxMin(double A[][]) {

	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int rows = 0;
		int cols = 0;

		double A[][] = new double[rows][cols];
		populate(A);
		
		System.out.println();
		
		PrintArray(A, 8, 2);
		
		double[][] rowStatistics = rowstats(A);
		System.out.println();
		
		PrintArray(rowStatistics, 8, 2);
		
		double[][] columnStatistics = ColMaxMin(A);
		
		
		
		//insert code to create array b with two more rows and columns than a
		
		
		System.out.println();
		
		PrintArray(columnStatistics, 8, 2);

	}

}
