import java.io.IOException;
import java.util.List;

public class Admin {

	public String addProduct(String barcode, String brand, String color, String connectivity, String quantity,
			String originalCost, String retailPrice, String category, String deviceType, String additionalInfo) {

		StockReader stockReader = new StockReader();
		try {
			List<String> stockData = stockReader.readStock();
			boolean productExists = false;
			// Go through stock data line by line
			for (int i = 0; i < stockData.size(); i++) {
				String line = stockData.get(i);
				// Make each line an object of the ExtendedProduct class
				ExtendedProduct product = stockReader.parseProduct(line);
				// Check if barcode already exists within Stock.txt
				if (product.getBarcode() == (Integer.parseInt(barcode))) {
					// If it does, make sure all other inputs are the same as in the database minus the quantity in stock
					if ((product.getBrand().equals(brand)) && (product.getColor().equals(color))
							&& (product.getConnectivity() == ConnectivityType.valueOf(connectivity.toUpperCase()))
							&& (product.getOriginalCost() == Double.parseDouble(originalCost))
							&& (product.getRetailPrice() == Double.parseDouble(retailPrice))
							&& (product.getCategory() == ProductCategory.valueOf(category.toUpperCase()))
							&& (product.getDeviceType() == DeviceType.valueOf(deviceType.toUpperCase()))) {
						int existingQuantity = product.getQuantityInStock();
						// Update the existing quantity in stock by adding whatever amount the user inputs to the existing stock
						int newQuantity = existingQuantity + Integer.parseInt(quantity);
						if (product != null) {
							product.setQuantityInStock(newQuantity);
						}
						// Update the line
						String updatedLine = String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s", barcode, category,
								deviceType, brand, color, connectivity, product.getQuantityInStock(), originalCost,
								retailPrice, additionalInfo);
						// Get rid of old line in the text file and add in the updated line
						stockData.remove(i);
						stockData.add(updatedLine);
						productExists = true;
						stockReader.writeStock(stockData);
						return "Product updated successfully.";
					} else {
						productExists = true;
						return "Barcode has been used already, product does not exist";
					}
				}
			}
			if (!productExists) {
				// If the product doesn't exist, add it to the file
				String productData = String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s", barcode, category,
						deviceType, brand, color, connectivity, quantity, originalCost, retailPrice, additionalInfo);
				stockData.add(productData);
				stockReader.writeStock(stockData);
				return "Product added successfully.";
			}

		} catch (IOException e) {
			return "Error reading/writing to file: " + e.getMessage();
		}

		return "";
	}

	public String validateData(String barcode, String brand, String color, String quantity, String originalCost,
			String retailPrice, String category, String additionalInfo) {
		// Make sure inputs are exactly the way we want them in the text file
		if (barcode.isEmpty() || brand.isEmpty() || color.isEmpty() || quantity.isEmpty() || originalCost.isEmpty()
				|| retailPrice.isEmpty() || additionalInfo.isEmpty()) {
			return "Make sure to fill in all information";
		}

		try {
			Integer.parseInt(barcode);
		} catch (NumberFormatException e) {
			return "Make sure barcode is an integer";
		}

		try {
			Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			return "Make sure quantity is an integer";
		}

		try {
			Double.parseDouble(originalCost);
		} catch (NumberFormatException e) {
			return "Make sure original cost is a number with no £ symbol";
		}

		try {
			Double.parseDouble(retailPrice);
		} catch (NumberFormatException e) {
			return "Make sure retail price is a number with no £ symbol";
		}

		try {
			Layout.valueOf(additionalInfo);
		} catch (IllegalArgumentException e) {
			try {
				Integer.parseInt(additionalInfo);
			} catch (NumberFormatException ex) {
				return "Additional Info should either be an integer or UK or US";
			}
		}

		if ("keyboard".equals(category)) {
			try {
				Layout.valueOf(additionalInfo.toUpperCase());
			} catch (IllegalArgumentException e) {
				return "Additional Info should be either UK or US as you have chosen keyboard";
			}
		} else if ("mouse".equals(category)) {
			try {
				Integer.parseInt(additionalInfo);
			} catch (NumberFormatException e2) {
				return "Additional Info should be an integer as you have chosen mouse";
			}
		}

		return "";
	}
}
