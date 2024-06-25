
public class AdultPrice implements PriceStrategy{

	@Override
	public double getAmount() {
		//the price for an adult is 15$
		return 15;
	}

	@Override
	public String getAge() {
		// returns that it is an adult
		return "Adult";
	}


	

}