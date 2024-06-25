package feet_to_feet_inches;

import java.util.Scanner;

public class feet_feet_inches {

	public static void main(String[] args) {
		
	/*
	 * George Fotiou
	 * 2/11/2020
	 * A program that converts feet into feet and inches
	 */
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the number of feet:");
		double x = keyboard.nextDouble();
		int y = (int) x;
		System.out.print(x + " feet = " + y + " feet");
		System.out.print( " " + (x-y)*12 + " inches");
	}

}
