import java.util.Scanner;

public class doublefactorial {

	public static long doubleFactorial(long i) {
		long x = i;

		do {

			if (x == 1) {
				i = i * x;
				x -=2;
			} 
			else if(x==2) {
		
				x -=2;
			}
			else {				
				x -=2;
				i = i * x;
			}
		} while (x > 0);
		return i;

		
		
	}
	
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int n = keyboard.nextInt();
		if (n < 0)
			System.out.print("Invalid input!");
		else if (n == 0)
			System.out.print("0!! = 1");
		else
			System.out.print(n + "!! = " + doubleFactorial(n));

	}

}
