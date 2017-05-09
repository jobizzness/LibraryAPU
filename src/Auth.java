import java.util.Scanner;

public class Auth{
 
	/**
	 * 
	 * @return
	 */
	public static User login() {
		
		Scanner scanner = new Scanner(System.in);
		String username, password;
		
		System.out.println("Please enter Username");
		username = scanner.nextLine();
		
		System.out.println("Please enter Password");
		password = scanner.nextLine();
		
		User user = Auth.attemptLogin(username, password);
		
		return user;
		
	}

	/**
	 * Attempts to log the user in.
	 * Returns null if it fails.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private static User attemptLogin(String username, String password) {
		
		User user = User.login(username, password);
		
		return user;
	}
	

}
