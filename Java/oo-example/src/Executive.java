
public class Executive extends Employee{
	
	//variables for executive
	private float stock_opt;
	private float bonus;
	
	//default constructor for executive
	public Executive() {
		super.setTitle("Executive");
		set_bonus(0);
		set_stock(0);
	}
	
	//constructor for executive
	public Executive(String l, String f, float s, float b, float st) {
		super.setln(l);
		super.setfn(f);
		super.setTitle("Executive");
		super.set_Sal(s);
		set_bonus(b);
		set_stock(st);
	}
	
	//sets the value of bonus
	public void set_bonus(float b) {
		bonus = b;
	}
	
	//sets the value of stock option
	public void set_stock(float st) {
		stock_opt = st;
	}
	
	//sets the salary
	public void setSal(float s) {
		super.set_Sal(s);
	}
	
	//returns the stock option value
	public float getStock() {
		return stock_opt;
	}

	//returns bonus 
	public float getBonus() {
		return bonus;
	}
	
	//calculates the salary for executive and returns a float
	public float calcSal() {
		return super.getSal() + getBonus() + getStock();
	}
	
	//displays the calculated salary
	public void display_sal() {
		System.out.println("Salary: " + calcSal());
	}
	
	//displays the bonus for the executive
	public void display_bonus() {
		System.out.println("Bonus: " + getBonus());
	}
	
	//displays stock option for executive
	public void display_stock() {
		System.out.println("Stock option: " + getStock());
	}
	
	//displays executive info
	public void display_info() {
		super.display_info();
		display_sal();
		display_bonus();
		display_stock();
		System.out.println();
	}
	
}//end of executive class
