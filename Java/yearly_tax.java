package yearly_tax;

import java.util.Scanner;

public class yearly_tax {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter income: ");
		double income = keyboard.nextDouble();

		if (income < 40000) {
			double tax_due = (income * .15);
			System.out.println("$" + tax_due);

		}

		if (income >= 40000 && income < 65000) {
			double tax_due = (income - 40000);
			System.out.print(("$" + tax_due * .2) + 6000);
		}

		if (income >= 65000 && income < 100000) {
			double tax_due = (income - 65000);
			System.out.print(("$" + tax_due * .25) + 11000);
		}
		if (income >= 100000 && income < 200000) {
			double tax_due = (income - 100000);
			System.out.print(("$" + tax_due * .275) + 19750);
		}
		if (income >= 200000) {
			double tax_due = (income - 200000);
			System.out.printf(("$" + tax_due * .3) + 47250);
		}
		
	
	}

}
