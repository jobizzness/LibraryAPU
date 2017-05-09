
public class AuthMiddleware {

	public static User user;
	
	public static void fire(User user) {
		
		AuthMiddleware.user = user;
		
		System.out.println("----- Welcome ------ \n");
		
		if(userIsAdmin()){
			AdminPanel panel = new AdminPanel(user);
			return;
		}
		
		LibrarianPanel panel = new LibrarianPanel(user);
		//send to librarian panel
		
	}

	/**
	 * Checks if user is Admin or not
	 * @return
	 */
	private static boolean userIsAdmin() {
		
		if(user.role.equalsIgnoreCase("admin")){
			return true;
		}
		return false;
	}

}
