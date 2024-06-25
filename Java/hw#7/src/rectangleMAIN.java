import java.util.Scanner;
/*
 * George Fotiou
 * 4/16/2020
 * This program determines the area, perimeter of a rectangle and if it is a square.
 */
public class rectangleMAIN {

	public static void PrintRectangleInformation(rectangle r) {
		System.out.println("Height: " + r.getheight());
		System.out.println("Width: " + r.getwidth());
		System.out.println("Area: " + r.area());
		System.out.println("Perimeter: " + r.perimeter());
		if (r.isSquare())
			System.out.println("The rectangle is a square.");
		else
			System.out.println("The rectangle is not a square.");
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.print("Input height and width of Rectangle #1: ");
		double h = kb.nextDouble();
		double w = kb.nextDouble();
		rectangle rectangle1 = new rectangle(h, w);
		System.out.print("Input height and width of Rectangle #2: ");
		h = kb.nextDouble();
		w = kb.nextDouble();
		rectangle rectangle2 = new rectangle(h, w);
		System.out.println();
		System.out.println(rectangle1);
		System.out.println(rectangle2);
		System.out.println();
		System.out.println("Rectangle 1");
		PrintRectangleInformation(rectangle1);
		System.out.println();
		System.out.println("Rectangle 2");
		PrintRectangleInformation(rectangle2);
		rectangle1.setHeight(17);
		rectangle1.setWidth(17);
		System.out.println();
		System.out.println("Rectangle 1");
		PrintRectangleInformation(rectangle1);
	}

}
