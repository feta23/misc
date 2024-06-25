
public class Test_Engineer extends Employee{
	
	private float ot_pay;
	
	public Test_Engineer() {
		ot_pay = 0;
		super.setTitle("Test Engineer");
	}
	
	public Test_Engineer(String l, String f, float s, float ps,float ot) {
		super.setln(l);
		super.setfn(f);
		super.setTitle("Test Engineer");
		super.set_Sal(s);
		set_ot(ot);
	}
	
	public void set_ot(float ot){
		ot_pay = ot;
	}
	
	public float getOT() {
		return ot_pay;
	}
	
	public float calcSal() {
		return super.getSal() + getOT();
	}
	
	
	public void display_sal() {
		System.out.println("Salary: " + calcSal());
	}
	
	public void display_ot() {
		System.out.print("Overtime Pay: " + getOT());
	}
	
	public void display_info() {
		super.display_info();
		display_sal();
		display_ot();
		System.out.println();
	}
}
