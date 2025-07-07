import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Basket {
	private DefaultTableModel model;

	public Basket(DefaultTableModel model) {
		this.model = model;
	}

	public static ExtendedProduct getProductByBarcode(int barcode) {
		// Find the product info using just the barcode
		StockReader stockReader = new StockReader();
		try {
			List<String> stockData = stockReader.readStock();
			for (String line : stockData) {
//            	System.out.println(line);
				ExtendedProduct product = stockReader.parseProduct(line);
				if (product.getBarcode() == barcode) {
					return product;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void loadBasketTable(List<Integer> selectedBarcodes) {
		model.setRowCount(0); // Clear existing rows
		// Go through all barcode that have been selected
		Iterator<Integer> iterator = selectedBarcodes.iterator();
		while (iterator.hasNext()) {
			int barcode = iterator.next();
			ExtendedProduct product = getProductByBarcode(barcode);
			if (product != null) {
				// Check if the quantity of products in the basket is greater than the quantity in stock
				// If it is greater then just allow the user to only have the maximum quantity, nothing more
				int count = Collections.frequency(selectedBarcodes, barcode);
				int quantityInStock = product.getQuantityInStock();
				while (count > quantityInStock) {
					iterator.remove();
					count -= 1;
				}
				boolean added = false;
				for (int row = 0; row < model.getRowCount(); row++) {
					int tableBarcode = (int) model.getValueAt(row, 0);
					if (tableBarcode == barcode) {
						int newQuantity = Math.min(count, quantityInStock); // Adjust quantity
						model.setValueAt(newQuantity, row, 8); // Update quantity in the table
						added = true;
					}
				}
				if (!added) {
					// Add a new row if the product does not already exist in the table
					Object[] rowData = createRow(product, count);
					model.addRow(rowData);
				}
			}
		}
	}

	private Object[] createRow(ExtendedProduct product, int count) {
		return new Object[] { product.getBarcode(), product.getBrand(), product.getColor(), product.getConnectivity(),
				product.getRetailPrice(), product.getCategory(), product.getDeviceType(), product.getAdditionalInfo(),
				count };
	}

	public double getTotalCost() {
		double totalCost = 0.0;
		for (int row = 0; row < model.getRowCount(); row++) {
			int quantity = (int) model.getValueAt(row, 8); // Get quantity
			double retailPrice = (double) model.getValueAt(row, 4); // Get retail price
			totalCost += quantity * retailPrice;
		}
		return Math.round(totalCost * 100.0) / 100.0;
	}

	public void updateStock(List<Integer> purchasedBarcodes) {
		// This is for once the user has paid
		// Makes changes to the stock quantity depending on what the user has bought
		StockReader stockReader = new StockReader();
		try {
			List<String> stockData = stockReader.readStock();
			List<String> updatedStockData = new ArrayList<>(stockData);

			for (int barcode : purchasedBarcodes) {
				for (int i = 0; i < updatedStockData.size(); i++) {
					String line = updatedStockData.get(i);
					
					ExtendedProduct product = stockReader.parseProduct(line);
					if (product != null && product.getBarcode() == barcode) {
						int newQuantity = product.getQuantityInStock() - 1; // Decrease quantity by 1
						// Update the line in the stock data with the new quantity
						String updatedLine = product.getBarcode() 
								+ ", " + product.getCategory().toString().toLowerCase() 
								+ ", " + product.getDeviceType().toString().toLowerCase() 
								+ ", " + product.getBrand() 
								+ ", " + product.getColor() 
								+ ", " + product.getConnectivity() .toString().toLowerCase() 
								+ ", " + newQuantity 
								+ ", " + product.getOriginalCost() 
								+ ", " + product.getRetailPrice() 
								+ ", " + product.getAdditionalInfo();
						updatedStockData.set(i, updatedLine);

						break; // Move to the next purchased item
					}
				}
			}

			// Save the updated stock data
			stockReader.writeStock(updatedStockData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
