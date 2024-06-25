
public class Main {

	public static void main(String[] args) {
		
		SalesOrder sale1 = new SalesOrder();
		
		TaxStrategy canada = new CanadaTax();
		TaxStrategy US = new USTax();
		TaxStrategy german = new GermanTax();
		
		
		PriceStrategy adult = new AdultPrice();
		PriceStrategy child = new ChildPrice();
		PriceStrategy senior = new SeniorPrice();
		
		
		sale1.setPriceStrategy(senior);
		sale1.setTaxStrategy(US);
		sale1.displayTicket();
		
		sale1.setPriceStrategy(adult);
		sale1.setTaxStrategy(canada);
		sale1.displayTicket();
		
		sale1.setPriceStrategy(child);
		sale1.setTaxStrategy(german);
		sale1.displayTicket();
		
		
	}

}
