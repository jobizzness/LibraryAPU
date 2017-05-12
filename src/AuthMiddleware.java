
public class AuthMiddleware {

	public static User user;
	
	public static void fire(User user) {
		
		AuthMiddleware.user = user;
		
		System.out.println("----- Welcome ------ \n");
		
		if(userIsAdmin()){
			 new Admin(user);
			return;
		}
		
		 new Librarian(user);
		
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
