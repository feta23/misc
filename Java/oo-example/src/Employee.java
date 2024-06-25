
public class Employee {
	//variables for employee class
	private  String fn;
	private  String ln;
	private  String title;
	private  float base_salary;

//constructor 
public Employee(String first, String last, String t, float sal) {
	fn = first;
	ln = last;
	title = t;
	base_salary = sal; 
}

//default constructor
public Employee() {
	fn = " ";
	ln = " ";
	title = " ";
	base_salary = 0;
}

//sets employees last name
public void setln(String l) {
	ln = l;
}

//sets employees first name
public void setfn(String f) {
	fn = f;
}

//sets employees job title
public void setTitle(String t) {
	title = t;
}

//set employees salary
public void set_Sal(float s) {
	base_salary = s;
}

//returns last name
public String getLn() {
	return ln;
}

//returns first name
public String getFn() {
	return fn;
}

//returns title
public String getTitle() {
	return title;
}

//returns base salary
public float getSal() {
	return base_salary;
}

//displays last name
public void displayln(){
		System.out.print(getLn());
}

//displays first name	
public void displayfn() {
		System.out.print(getFn());
}

//displays base salary
public void display_baseSal() {
		System.out.print(getSal());
}

//displays title
public void display_title() {
		System.out.print(getTitle());
}

//displays employees info
public void display_info() {
		System.out.println(getLn() + ", " + getFn());
		System.out.println("Title: " + getTitle());
}

}//End of Employee class



