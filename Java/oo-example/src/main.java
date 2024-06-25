
public class main {
	public static void main(String[] args) {
	
	Employee arr[] = new Employee[3]; 
	
	Executive emp0 = new Executive("Fotiou", "George", 10000,150,250);
	
	Soft_Engineer emp1 = new Soft_Engineer("Rarig", "Jacob", 2000,125,300);
	
	Test_Engineer emp2 = new Test_Engineer("Dickens", "Bret", 1000,250,100);
	
	arr[0] = emp0;
	arr[1] = emp1;
	arr[2] = emp2;
	
	arr[0].display_info();
	arr[1].display_info();
	arr[2].display_info();
	
	System.out.println();
	
	emp0.display_info();
	emp1.display_info();
	emp2.display_info();

				
	}

}
