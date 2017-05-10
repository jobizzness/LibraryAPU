import java.util.Scanner;

public class LibrarianPanel {

	public LibrarianPanel(User user) {
		
		this.user = user;
		this.showOptions();

	}
	private User user;
	private String response;
	

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

	private void showOptions() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 0 to search a book");
		System.out.println("Enter 1 to view a book");
		System.out.println("Enter 2 to modify a book");
		System.out.println("Enter 3 for checkIn");
		System.out.println("Enter 4 for checkOut");
		System.out.println("Enter 5 for reporting");
		System.out.println("Enter 6 to go back");
		
		this.response = scanner.next();

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
		 		this.goBack();
	 		break;
	 		default:
	 			System.out.println("Sorry you may have enterd a wrong function \n");
	 			System.out.println("------------------------------------------------");
	 			this.showOptions();
		 }
		
	}

	private void goBack() {
		/**
		 * Instantiate main app class
		 */
		new App().kickstart();

		
	}

}
