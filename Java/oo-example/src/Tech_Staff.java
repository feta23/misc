
public class Tech_Staff extends Employee{
	
	//variable to store profit sharing value
	private float profit_sharing;
	
	//default constructor
	public Tech_Staff() {
		set_ps(0);
		super.setTitle("Tech Staff");
	}
	
	//constructor
	public Tech_Staff(String l, String f, float s, float ps) {
		super.setln(l);
		super.setfn(f);
		super.setTitle("Tech Staff");
		super.set_Sal(s);
		set_ps(ps);
	}
	
	//sets the assigns the value of profit sharing
	 public void set_ps(float p){
		 profit_sharing = p;
	 }
	 
	 //returns profit sharing
	 public float getPS() {
		 return profit_sharing;
	 }
	 
	 //calculates and returns tech staff salary
	 public float calcSal() {
		 return super.getSal() + getPS();
	 }
	 
	 //displays profit sharing 
	 public void display_ps() {
		 System.out.println("Profit Sharing " + getPS());
	 }
	 
	 //displays salary
	 public void display_sal() {
		 System.out.println("Salary: " + calcSal());
	 }
	 
	 //displays all the info for tech staff
	 public void display_info() {
		 super.display_info();
		 display_sal();
		 display_ps();
		 System.out.println();
	 }
	 
}
