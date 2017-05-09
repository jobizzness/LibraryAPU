import java.util.Scanner;

public class AdminPanel {
	
	private User user;
	private String response;
	
	public AdminPanel(User user) {
		
		this.user = user;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 0 to search a book");
		System.out.println("Enter 1 to view a book");
		System.out.println("Enter 2 to modify a book");
		System.out.println("Enter 3 for checkIn");
		System.out.println("Enter 4 for checkOut");
		System.out.println("Enter 5 for reporting");
		System.out.println("Enter 6 to add a new User");
		System.out.println("Enter 7 to go back");
		
		this.response = scanner.next();
		
		/**
		 * 
		 */
		 switch(response){
		 	case "0":
		 		this.searchBook();
	 		break;
		 	case "1":
		 		this.viewBook();
	 		break;
		 	case "2":
		 		this.modifyBook();
	 		break;
		 	case "3":
		 		this.checkIn();
	 		break;
		 	case "4":
		 		this.checkOut();
	 		break;
		 	case "5":
		 		this.reporting();
	 		break;
		 	case "6":
		 		this.addNewUser();
	 		break;
		 	case "7":
		 		this.goBack();
	 		break;
		 }
	}

	private void goBack() {
		/**
		 * Instantiate main app class
		 */
		new App().kickstart();

		
	}

	private void addNewUser() {
		// TODO Auto-generated method stub
		
	}

	private void reporting() {
		// TODO Auto-generated method stub
		
	}

	private void checkOut() {
		// TODO Auto-generated method stub
		
	}

	private void checkIn() {
		// TODO Auto-generated method stub
		
	}

	private void modifyBook() {
		// TODO Auto-generated method stub
		
	}

	private void viewBook() {
		// TODO Auto-generated method stub
		
	}

	private void searchBook() {

		
	}

}
