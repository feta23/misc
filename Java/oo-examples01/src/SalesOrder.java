
public class SalesOrder {
	
	double price;
	double tax;
	String country;
	String age;
	
	TaxStrategy taxStrategy;
	PriceStrategy priceStrategy;
	
	
	void setTaxStrategy(TaxStrategy ts) {
		taxStrategy = ts;
		setTax();
		setCountry();
	}
	
	void setPriceStrategy(PriceStrategy ps) {
		priceStrategy = ps;
		setPrice();
		setAge();
	}
	
	void setPrice() {
		price = priceStrategy.getAmount();
	}
	
	void setTax() {
		tax = taxStrategy.getAmount(getPrice());
	}
	
	void setCountry() {
		country = taxStrategy.getCountry();
	}
	
	void setAge() {
		age = priceStrategy.getAge();
	}
	
	double getPrice() {
		return price;
	}
	
	double getTax() {
		return tax;
	}
	
	void displayTicket() {
		System.out.println("Sale Summary");
		System.out.println("Ticket Type: " + age);
		System.out.println("Country Tax: " + country);
		System.out.println("Ticket Price: " + getPrice() + "$");
		System.out.println("Tax: " + getTax() + "$");
		System.out.println("Total: " + (price + tax) + "$");
		System.out.println();
	}
	
	
}
