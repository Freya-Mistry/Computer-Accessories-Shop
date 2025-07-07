
public class ExtendedProduct extends Product{
	private DeviceType deviceType;
	private Object additionalInfo;
	
	public ExtendedProduct(int barcode,  String brand, String color, ConnectivityType connectivity, int quantityInStock, double originalCost, double retailPrice, ProductCategory category, DeviceType deviceType, Object additionalInfo) {
		super(barcode, brand, color, connectivity, quantityInStock, originalCost, retailPrice, category);
		this.deviceType = deviceType;
		this.additionalInfo = additionalInfo;
	}
	
	public DeviceType getDeviceType() {
		return deviceType;
	}
	
	public Object getAdditionalInfo() {
		return additionalInfo;
	}
	
	@Override
	public String toString() {
		String str = getBarcode() +
					", " + getBrand() +
					", " + getColor() +
					", " + getConnectivity() +
					", " + getQuantityInStock() +
					", " + getOriginalCost() +
					", " + getRetailPrice() +
					", " + getCategory() +
					", " + deviceType +
					", " + additionalInfo;
		return str;
	}
}
