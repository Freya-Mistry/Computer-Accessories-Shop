import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class UserAccountsReader {

	private static final String USER_ACCOUNTS_TEXT_FILE = "UserAccounts.txt";

	public List<String> readUserAccounts() throws IOException {
		List<String> userAccounts = new ArrayList<>();

		FileReader inputFile = new FileReader(USER_ACCOUNTS_TEXT_FILE);
		BufferedReader br = new BufferedReader(inputFile);
		// Read UserAccounts.txt line by line
		String line;
		while ((line = br.readLine()) != null) {
			userAccounts.add(line);
		}

		br.close();

		return userAccounts;
	}
	
	public User parseUser(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 7) {
            try {
            	// Parse each element into its correct type
                int userId = Integer.parseInt(parts[0].trim());
                String username = parts[1].trim();
                String name = parts[2].trim();
                int houseNumber = Integer.parseInt(parts[3].trim());
                String postcode = parts[4].trim();
                String city = parts[5].trim();
                Role role = Role.valueOf(parts[6].trim().toUpperCase());
                
                return new User(userId, username, name, houseNumber, postcode, city, role);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid role in user account: " + parts[6].trim());
                return null;
            }
        } else {
            System.err.println("Invalid user account format: " + line);
            return null;
        }
    }

}
