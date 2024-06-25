package timeAndHeight;

import java.util.Scanner;

public class TimeAndHeight {

	public static double height(double d0,double v0, double  t) {

		double g = 32.17405;
		double d = ((-1.0/2)*g*t*t) + v0*t + d0;
		
		return d;
		
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input the Initial Height (in feet): ");
		Double d0 = keyboard.nextDouble();
		System.out.print("Input the Initial Velocity (in feet/sec.): ");
		Double v0 = keyboard.nextDouble();
		double d = d0; double t = 0;
		    System.out.println();
		    System.out.println(" Time Height");
		while (d > 0) {
		
			d = height(d0, v0, t); if (d > 0)
		System.out.printf("%5.1f %15.3f \n", t, d); else
		    System.out.printf("%5.1f %20s \n", t, "Hit the ground.");
		t += 0.1;
	}
	}
}

