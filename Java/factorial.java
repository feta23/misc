package factorial;

import java.util.Scanner;

public class factorial {

	public static long factorial(long i) {
		Scanner keyboard = new Scanner(System.in);
		long x = i;

		do {

			if (x == 1) {
				i = i * x;
				x--;

			} else {
				x--;
				i = i * x;

			}
		} while (x != 0);
		return i;

	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int n = keyboard.nextInt();
		if (n < 0)
			System.out.print("Invalid input!");
		else if (n == 0)
			System.out.print("n! = 1");
		else

			System.out.print(n + "! = " + factorial(n));

	}

}
