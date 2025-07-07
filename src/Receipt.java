import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Receipt {
	private double amount;
	private String paymentMethod;
	private LocalDate date;
	private Address address;
	
	public Receipt (double amount, String paymentMethod, Address address) {
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.address = address;
		this.date = LocalDate.now();
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Address getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
		String str = amount + ", " + paymentMethod + ", " + formattedDate + ", " + address;
		return str;
	}
}
