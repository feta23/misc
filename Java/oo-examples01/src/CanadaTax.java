
public class CanadaTax implements TaxStrategy{

	@Override
	public double getAmount(double v) {
		//Canada will have a 10% tax
		
		return (v * .1);
	}

	@Override
	public String getCountry() {
		// returns that it is Canada
		return "Canada";
	}
	
}
