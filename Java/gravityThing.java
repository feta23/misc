package gravityThing;

import java.util.Scanner;

public class gravityThing {

	public static void main(String[] args) {
		/*
		 * George Fotiou
		 * 3/26/2020
		 * This program calculates an object falling
		 */
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Input the initial height (in ft):");
		
		double IntHeight = keyboard.nextDouble();
		System.out.print("Input the initial velocity (in feet/sec):");
		
		double IntVelocity = keyboard.nextDouble(); 
	
		double t = 0.0;
	
		double grav = 32.17405;
		
		double d = 1;
		System.out.print("Time           Height");
		System.out.print("----           ------");
		while (d>0) {
			d = (-0.5 * grav * Math.pow(t, 2)) + IntVelocity * t + IntHeight;
			if (d<=0) {
				System.out.printf("%.1f", t);
				System.out.print("      Hit the ground.");
			}
			else {
				System.out.printf("%.1f", t);
				System.out.printf("%15.3\n", d);
			}
		}
	}

}
