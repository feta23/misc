
public class SeniorPrice implements PriceStrategy{

	@Override
	public double getAmount() {
		// Senior price will be 5$
		return 5;
	}

	@Override
	public String getAge() {
		// returns that it is a senior
		return "Senior";
	}

}
