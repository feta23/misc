import java.util.Scanner;
/*
 * George Fotiou
 * 4/16/2020
 * This program finds the cords, radius, circumfrence, area of a cirlce. Also determines if two circles will collide. 
 */
public class question2 {
	public static void printProperties(Circle c){
		
		System.out.println("Properties");
		System.out.println("Cirlce = (" + c.getCenterX()+ ", "+ c.getCenterY()+")");
		System.out.println("Radius =" + c.getRadius());
		System.out.println("Circumfrence =" + c.Circumfrence());
		System.out.println("Area =" + c.Area());
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Input the X coordinate of the center: ");
		double cx = keyboard.nextDouble();
		
		System.out.print("Input the Y coordinate of the center: ");
		double cy = keyboard.nextDouble();
		
		System.out.print("Input the radius: ");
		double rad = keyboard.nextDouble();
		
		Circle circle1 = new Circle(cx, cy, rad);
		printProperties(circle1);
		
		Circle circle2 = new Circle(2, 3, 2);
		printProperties(circle2);
		
		Circle circle3 = new Circle(4, 5, 1);
		printProperties(circle3);
		
		Circle circle4 = new Circle(0, 0, 3);
		printProperties(circle4);
		
		System.out.println();
		System.out.println(circle2.collide(circle3));
		System.out.println(circle2.collide(circle4));
		System.out.println(circle3.collide(circle4));

	}

}
