
public class PayWithCreditCard implements PaymentMethod {

	@Override
	public Receipt processPayment(double amount, Address fullAddress) {
		return new Receipt(amount, "Credit Card", fullAddress);
	}

	public String validateData(String cardNumber, String securityCode) {
		try {
			if (cardNumber.isEmpty() || securityCode.isEmpty()) {
				return "Make sure all fields are filled";
			}
			Integer.parseInt(cardNumber);
			Integer.parseInt(securityCode);
			
			if (cardNumber.length() != 6) {
				return "Make sure card number is of length 6";
			} else if (securityCode.length() != 3) {
				return "Make sure security code is of length 3";
			} else {
				return "";
			}
			
		} catch (NumberFormatException e) {
			return "Make sure both values are integers";
		}
	}

}
