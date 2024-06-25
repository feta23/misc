
public class Manager extends Employee{
	
//variable to store managers bonus
private float bonus;
	
//Manager default constructor
public Manager() {
	set_bonus(0);
	super.setTitle("Manager");
}

//Manager constructor
public Manager(String l, String f, float s, float b) {
	super.setln(l);
	super.setfn(f);
	super.setTitle("Manager");
	super.set_Sal(s);
	set_bonus(b);
}

//to set the value of bonus
public void set_bonus(float b) {
	bonus = b;
}

//returns bonus 
public float getBonus() {
	return bonus;
}

//calculates and returns manager salary which is base salary + bonus
public float calcSal() {
	return super.getSal() + getBonus();
}

//displays the bonus for the manager
public void display_bonus() {
	System.out.println("Bonus: " + getBonus());
}


//displays the salary for the manager
public void display_sal() {
	System.out.println("Salary: " + calcSal());
}

//displays all the managers information
public void display_info() {
	super.display_info();
	display_sal();
	display_bonus();
	System.out.println();
}
	
}//end of manager class
