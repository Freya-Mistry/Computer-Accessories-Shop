public abstract class Product {
	private int barcode;
	private String brand;
	private String color;
	private ConnectivityType connectivity;
	private int quantityInStock;
	private double originalCost;
	private double retailPrice;
	private ProductCategory category;
	
	public Product(int barcode,  String brand, String color, ConnectivityType connectivity, int quantityInStock, double originalCost, double retailPrice, ProductCategory category) {
		this.barcode = barcode;
		this.brand = brand;
		this.color = color;
		this.connectivity = connectivity;
		this.quantityInStock = quantityInStock;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
		this.category = category;
	}
	
	public int getBarcode() {
		return barcode;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public ProductCategory getCategory() {
		return category;
	}
	
	public String getColor() {
		return color;
	}
	
	public ConnectivityType getConnectivity() {
		return connectivity;
	}
	
	public double getOriginalCost() {
		return originalCost;
	}
	
	public int getQuantityInStock() {
		return quantityInStock;
	}

	public double getRetailPrice() {
		return retailPrice;
	}
	
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	public abstract String toString();
}
