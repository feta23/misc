/*
 * George Fotiou
 * 4/16/2020
 * This object determines the cords, radius, circumfrence, area of a cirlce. Also determines if two circles will collide.
 */
public class Circle {
	private double x;
	private double y;
	private double z;
	private double radius;
	private double sa;
	private double volume;
	private double circumfrence;
	private double area;
	
	public Circle() {
		 x = 0.0;
		 y = 0.0;
		 radius = 0.0;
	}
	//accessor for x , y , z, and radius
	public Circle(double cx, double cy, double zx, double rad) {

		 x = cx;
		 y = cy;
		 z = zx;
		 radius = rad; 
	}
	public void setCenter(double cx, double cy) {
		x = cx;
		y = cy;	
	}
	public void setRadius(double rad) {
		 radius = rad;
	}
	public double getCenterX() {
		return x;
	}
	public double getCenterY() {
		return y;
	}
	public double getRadius() {
		return radius;
	}
	public double Circumfrence() {
	   circumfrence = 2*(Math.PI)*radius;
			  return circumfrence; 
	}
	public double Area() {
		area = Math.PI * radius * radius;
		return area;
	}
	public boolean collide(Circle c) {
		double radii = radius + c.radius;
		double collide = Math.sqrt(Math.pow((c.x - x),2)+ Math.pow((c.y - y),2));
		if (collide<radii) {
			return true;
		}else return false;
	}
	public double Volume() {
		volume = (4/3) * (Math.PI) * Math.pow(radius, 3); 
		return volume;
	}
	public double SurfaceArea() {
		sa = (4*Math.PI*Math.pow(radius, 2));
		return sa; 
	}
}
