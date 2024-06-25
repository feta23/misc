import java.util.Scanner;

public class Miles_to_feet {

	public static void main(String[] args) {
		/*
		 * George Fotiou
		 * 2/11/2020
		 * A program that converts miles to feet
		 */
		
		Scanner keyboard = new Scanner(System.in);			
		
		System.out.print("Enter miles:");
		double x = keyboard.nextDouble();
		double y = x * 5280;
		System.out.print("There are " + y + " feet in " + x + " miles" );
		
	}

}
