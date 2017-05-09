import java.util.Scanner;

public class App {
	
	public int response;
	
	/**
	 * This starts the App
	 */
	public void kickstart(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=========== Welcome to Knowledgica Public Libary ===========");
		System.out.println("Please enter 0 if you are a Guest");
		System.out.println("Please enter 1 if you are a Staff");
		
		this.response = scanner.nextInt();
		
		/**
		 * This fires if the user is a guest
		 */
		if(this.response == 0){
			Guest guest = new Guest();
			return;
		}
		
		/**
		 * This fires if the user is a staff
		 */
		if(this.response == 1){
			//Try to log the user in
			try{
				User user = Auth.login();
				
				// If there is no user then the details are wrong
				if(user == null) {
			          throw new FailedLoginException("Sorry the details are incorrect.");
			     }
				//Check if the user is Admin or Librarian
				AuthMiddleware.fire(user);
				
				
			} 
			//If we are here then the Authentication failed
			catch(FailedLoginException ex){
				
				System.out.println(ex);
				this.reset();
			}
			return;
		}
		
		// Wrong option was chosen.
		System.out.println("Sorry this function Does not exist...");
		this.reset();

	}
	
	private void reset() {
		this.kickstart();
		
	}


}
