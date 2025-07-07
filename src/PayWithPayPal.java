
public class PayWithPayPal implements PaymentMethod {
	
	@Override
	public Receipt processPayment(double amount, Address fullAddress) {
		return new Receipt(amount, "PayPal", fullAddress);
	}
	
	public boolean validateData(String Email) {
		if (Email.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
}
