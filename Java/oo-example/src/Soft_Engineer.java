
public class Soft_Engineer extends Employee{
	
	//variables for soft engineer
	private float profit_sharing;
	private float ot_pay;
	
	//default constructor
	public Soft_Engineer() {
		set_ps(0);
		set_ot(0);
		super.setTitle("Software Engineer");
	}
	
	//constructor
	public Soft_Engineer(String l, String f, float s, float ps,float o) {
		super.setln(l);
		super.setfn(f);
		super.setTitle("Software Engineer");
		super.set_Sal(s);
		set_ps(ps);
		set_ot(o);
	}
	
	//assigns the value of over time pay
	public void set_ot(float o) {
		ot_pay = o;
	}
	
	//assigns the value of profit sharing
	public void set_ps(float p){
		 profit_sharing = p;
	}
	
	//returns the value of profit sharing 
	public float getPS() {
		return profit_sharing;
	}
	
	//returns the value of over time pay
	public float getOT() {
		return ot_pay;
	}
	
	//calculates and returns the value of salary
	public float calcSal() {
		return super.getSal() + getOT() + getPS();
	}
	
	//displays profit sharing 
	public void display_ps() {
		System.out.println("Profit Sharing: " + getPS());
	}
	
	//displays over time pay
	public void display_ot() {
		System.out.println("Overtime Pay: " + getOT());
	}
	
	//displays soft engineers salary
	public void display_sal() {
		System.out.println("Salary: " + calcSal());
	}
	
	public void display_info() {
		super.display_info();
		display_sal();
		display_ot();
		display_ps();
		System.out.println();
	}
	
	}//end of soft engineer class
