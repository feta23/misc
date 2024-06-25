
/*
 * George Fotiou
 * 4/16/2020
 * This object is for determining the area, perimeter of a rectangle and if it is a square.
 */
public class rectangle {
	private double width;
	private double height;

	
//constructor
	public rectangle(double h, double w) {

		height = h;
		width = w;
	}

//accessors
	public double getheight() {
		return height;
	}

	public double getwidth() {
		return height;
	}
	
	public double perimeter() {
		double perimeter = height+height+width+width;
		return perimeter;
	}
	
	public double area() {
		double area = height * width;
		return area;
	}

	public String toString() {
		 String restr = " ";
		restr =  "Height = "+height + "  Width = "+width;
		return restr;
	}
	public void setWidth(double w) {
		width = w;
	}
	public void setHeight(double h) {
		height = h;
	}
	public boolean isSquare() {
		if(height == width) {
			return true;
		}else 
			return false;
		
	}
}
