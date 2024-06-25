package quardratic_formula;

import java.util.Scanner;

public class quadratic_formal {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		double aIsLessThanZero = 0;
		
		System.out.print("Input  a: ");
		double a = keyboard.nextDouble();
		System.out.print("Input  b: ");
		double b = keyboard.nextDouble();
		System.out.print("Input  c: ");
		double c = keyboard.nextDouble();
	
		if (a>0){
		double quadratic_formula = (b* ((Math.sqrt((b*b)-4*a*c)))/(2*a));
		System.out.println(quadratic_formula);
		}
		else if (c<0) {
			System.out.print("All real numbers");
		}else if (a==0)
			aIsLessThanZero = -(c/b);
			System.out.print(aIsLessThanZero);
		}
	}

