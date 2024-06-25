import java.util.ArrayList;
import java.util.Scanner;

public class question2 {

	//Takes in the array list of circles, and number of spheres and prints a list of the circles that collide 
	public static void collideList(ArrayList<Circle> A, int spheres) {

		System.out.println("Collision List");
		for (int i = 0; i < spheres; ++i) {

			double x = 0.0;
			double y = 0.0;
			double z = 0.0;
			double radius = 0.0;
			int j = 0;
			
			j = i + 1;
			x = A.get(i).getCenterX();
			y = A.get(i).getCenterY();
			z = A.get(i).getZ();
			radius = A.get(i).getRadius();

			Circle circle1 = new Circle(x, y, z, radius);
			Circle circle2 = new Circle(x, y, z, radius);
		
				if (circle1.collide(circle2)) {
					System.out.println("Spheres " + (i + 1) + " and " + (j + 1) + " collide.");
				}
			}
		}
	
//takes in the circle and prints the coordinates, radius, circumference, area
//and prints them 
	public static void printProperties(Circle c) {

		System.out.println("Properties");
		System.out.println("Cirlce = (" + c.getCenterX() + ", " + c.getCenterY() + ", " + c.getZ() + ")");
		System.out.println("Radius =" + c.getRadius());
		System.out.println("Circumfrence =" + c.Circumfrence());
		System.out.println("Area =" + c.Area());
		System.out.println();
	}

	public static void main(String[] args) {

		/*
		 * George Fotiou 
		 * 4/27/2020 
		 * User inputs amount of spheres and prints the spheres
		 * properties and a list of who collides
		 */

		Scanner kbd = new Scanner(System.in);
		int spheres = 0;
		char y;
		char n;
		double cx = 0;
		double cy = 0;
		double zx = 0;
		double radius = 0;
		char Ans1 = 'v';
		char Ans2 = 'v';
		
		//make an array list that takes in circles to access later 
		ArrayList<Circle> Allspheres = new ArrayList<Circle>();

		for (int i = 0; i < 1;) {

			System.out.print("Input the number of spheres (5-100):");
			spheres = kbd.nextInt();

			System.out.print("Print Sphere Information (Y/N): ");
			String SphereYN = kbd.next().toUpperCase();

			System.out.print("Print Collision List (Y/N):");
			String ColYN = kbd.next().toUpperCase();
			System.out.println();
			
			//save answer as a single char
			Ans1 = SphereYN.charAt(0);
			Ans2 = ColYN.charAt(0);
			
//number of spheres has to be greater than 5 and less than 100
			if (spheres < 5 || spheres > 100) {
				System.out.println("Please enter a valid input of spheres.");
				System.out.println();
			} else {
				++i;
			}
		}
		if (Ans1 == 'Y') {
			for (int i = 0; i < spheres; ++i) {
				cx = (Math.random() * (20)) - 11;
				cy = (Math.random() * (20)) - 11;
				zx = (Math.random() * (20)) - 11;
				radius = (Math.random() * 3) + 1;

				Circle circle = new Circle(cx, cy, zx, radius);
				Allspheres.add(circle);
				printProperties(circle);

			}
		}
		if (Ans2 == 'Y') {
			collideList(Allspheres, spheres);
		}

	}

}
