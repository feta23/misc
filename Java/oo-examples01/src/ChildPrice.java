
public class ChildPrice implements PriceStrategy{

	@Override
	public double getAmount() {
		// Children price will be 7$
		return 7;
	}

	@Override
	public String getAge() {
		// returns that it is a child
		return "Child";
	}

}
