import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockReader {
	private static final String STOCK_TEXT_FILE = "Stock.txt";

	public List<String> readStock() throws IOException {
		List<String> stock = new ArrayList<>();
		FileReader inputFile = new FileReader(STOCK_TEXT_FILE);
		BufferedReader br = new BufferedReader(inputFile);
		// Read the stock line by line
		String line;
		while ((line = br.readLine()) != null) {
			stock.add(line);
		}

		br.close();

		return stock;
	}
	
	public void writeStock(List<String> stockData) throws IOException {
		// Write a line into the Stock.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STOCK_TEXT_FILE))) {
            for (String line : stockData) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
	
	public ExtendedProduct parseProduct(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 9) {
            try {
            	// Parse each element into its correct type
                int barcode = Integer.parseInt(parts[0].trim());
                ProductCategory category = ProductCategory.valueOf(parts[1].trim().toUpperCase());
                DeviceType deviceType = DeviceType.valueOf(parts[2].trim().toUpperCase());
                String brand = parts[3].trim();
                String color = parts[4].trim();
                ConnectivityType connectivity = ConnectivityType.valueOf(parts[5].trim().toUpperCase());
                int quantityInStock = Integer.parseInt(parts[6].trim());
                double originalCost = Double.parseDouble(parts[7].trim());
                double retailPrice = Double.parseDouble(parts[8].trim());
                Object additionalInfo = parseAdditionalInfo(parts[9].trim());
                
                return new ExtendedProduct(barcode, brand, color, connectivity, quantityInStock, originalCost, retailPrice, category, deviceType, additionalInfo);
            } catch (IllegalArgumentException e) {
            	System.err.println("Error parsing product: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Invalid product format: " + line);
            return null;
        }
    }
	
	private Object parseAdditionalInfo(String additionalInfoStr) {
		// Additional info can either be of type Layout or of type Integer
        try {
            return Layout.valueOf(additionalInfoStr);
        } catch (IllegalArgumentException e) {
            try {
                return Integer.parseInt(additionalInfoStr);
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }

}
