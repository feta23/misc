
public class GermanTax implements TaxStrategy{

	@Override
	public double getAmount(double v) {
		//Germany will have a 13% tax
		return (v * .13);
	}

	@Override
	public String getCountry() {
		// returns its the country Germany
		return "Germany";
	}
	
}
