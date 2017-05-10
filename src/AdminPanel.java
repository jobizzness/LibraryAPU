import java.io.IOException;
import java.util.Scanner;

public class AdminPanel {
	
	private User user;
	private String response;
	private Scanner scanner;
	
	public AdminPanel(User user) {
		
		this.user = user;
		this.scanner = new Scanner(System.in);
		this.showOptions();
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
		
		System.out.println("Enter book ID");
		
		String ID = this.scanner.nextLine();
		
		Book book = Book.search(ID);
		
		Book newBook = new Book(book.id, book.title, book.availability, book.author, book.shelve_no);
		newBook.title = "cool stuff";
		newBook.author = "ladyboy";
		
		if(book != null){
			
			try {
				FileSystem.modify(Book.getFile(), book, newBook);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private void viewBook() {
		// TODO Auto-generated method stub
		
	}

	private void searchBook() {

		
	}
	
	private void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	private void deleteBook() {
		// TODO Auto-generated method stub
		
	}

	private void showOptions() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 0 to search a book");
		System.out.println("Enter 1 to view a book");
		System.out.println("Enter 2 to modify a book");
		System.out.println("Enter 3 for checkIn");
		System.out.println("Enter 4 for checkOut");
		System.out.println("Enter 5 for reporting");
		System.out.println("Enter 6 to add a new User");
		System.out.println("Enter 7 to delete a book");
		System.out.println("Enter 8 to delete a User");
		System.out.println("Enter 9 to go back");
		
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
		 		this.addNewUser();
	 		break;
		 	case "7":
		 		this.deleteBook();
	 		break;
		 	case "8":
		 		this.deleteUser();
	 		break;
		 	case "9":
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
