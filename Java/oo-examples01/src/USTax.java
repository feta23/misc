
public class USTax implements TaxStrategy{
	@Override
	public double getAmount(double v) {
		//v is the price of the product
		//US will have a 7% tax of the price
	
		return (v * .07);
	}

	@Override
	public String getCountry() {
		// returns the country US
		return "US";
	}

}
