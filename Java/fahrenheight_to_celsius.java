package fahrenheightTocelsius;

import java.util.Scanner;
public class fahrenheight_to_celsius {

public static double celsius(double i){
	
	double c =((5.0/9)*(i-32));
	return c;
}

/*
 * George Fotiou
 * 4/6/2020
 * This program prints out celsius to Fahrenheit
 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Fahrenheit Celsius");
		
		for (int i = -50; i <= 150; i += 5)
			{System.out.printf("%6d %10.2f\n", i, celsius(i));
		}
		
	}


		
		
	}


