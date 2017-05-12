import java.io.IOException;
import java.util.Scanner;

public class Admin extends User{
	

	private String response;
	private Scanner scanner;
	
	public Admin(User user) {
		
		super(user.ID, user.username, user.password, user.firstname, user.lastname, user.role);
		
		this.scanner = new Scanner(System.in);
		this.showOptions();
	}
	

	public void checkOut() {
		System.out.println("Enter book ID");
		
		String ID = this.scanner.nextLine();
		
		Book book = Book.search(ID);
		
		if(book != null){
			
			Book newBook = new Book(book.id, book.title, false, book.author, book.shelve_no);
			
			try {
				FileSystem.modify(Book.getFile(), book, newBook);
				System.out.println("Checkout Successful Success!");
				System.out.println("---------------------------------");
			} catch (IOException e) {
				System.out.println("Sorry there was an error!");
				System.out.println("---------------------------------");
				e.printStackTrace();
			}
			this.showOptions();
		}
		
		System.out.println("Sorry Book was not found");
		System.out.println("---------------------------------");
		this.showOptions();
		
	}

	public void checkIn() {
		System.out.println("Enter book ID");
		
		String ID = this.scanner.nextLine();
		
		Book book = Book.search(ID);
		
		if(book != null){
			
			Book newBook = new Book(book.id, book.title, true, book.author, book.shelve_no);
			
			try {
				FileSystem.modify(Book.getFile(), book, newBook);
				System.out.println("CheckIn Successful!");
				System.out.println("---------------------------------");
			} catch (IOException e) {
				System.out.println("Sorry there was an error!");
				System.out.println("---------------------------------");
				e.printStackTrace();
			}
			this.showOptions();
		}
		
		System.out.println("Sorry Book was not found");
		System.out.println("---------------------------------");
		this.showOptions();
		
	}
	

	public void reporting() {
		System.out.println("---------------------------------");
		System.out.println("Reporting");
		
		Book.reportAll();
		
	}

	public void modifyBook() {
		
		System.out.println("Enter book ID");
		
		String ID = this.scanner.nextLine();
		
		Book book = Book.search(ID);
		
		if(book != null){
			
			Book newBook = new Book(book.id, book.title, book.availability, book.author, book.shelve_no);
			
			try {
				FileSystem.modify(Book.getFile(), book, newBook);
				System.out.println("Successfully modified...");
				System.out.println("---------------------------------");
			} catch (IOException e) {
				System.out.println("Sorry there was an error!");
				System.out.println("---------------------------------");
				e.printStackTrace();
			}
			this.showOptions();
		}
		
		System.out.println("Sorry Book was not found");
		System.out.println("---------------------------------");
		this.showOptions();
		
		
	}


	
	public void deleteBook() {
		
		System.out.println("Enter book ID");
		
		String ID = this.scanner.nextLine();
		
		Book book = Book.search(ID);
		
		if(book != null){
			
			try {
				FileSystem.removeObject(Book.getFile(), book);
				System.out.println("Successfully deleted from the records...");
				System.out.println("---------------------------------");
			} catch (IOException e) {
				System.out.println("Sorry there was an error!");
				System.out.println("---------------------------------");
				e.printStackTrace();
			}
			this.showOptions();
		}
		
		System.out.println("Sorry Book was not found");
		System.out.println("---------------------------------");
		this.showOptions();
	}
	
	public void deleteUser() {
		
		
	}


	
	public void addNewUser() {
		
		
	}

	public void showOptions() {
		System.out.println("---------------------------------");
		System.out.println("Enter 0 to search a book");
		System.out.println("Enter 1 to view a book");
		System.out.println("Enter 2 to modify a book");
		System.out.println("Enter 3 for checkIn");
		System.out.println("Enter 4 for checkOut");
		System.out.println("Enter 5 for reporting");
		System.out.println("Enter 6 to add a new User");
		System.out.println("Enter 7 to add a new Book");
		System.out.println("Enter 8 to delete a book");
		System.out.println("Enter 9 to delete a User");
		System.out.println("Enter 10 to go back");
		
		this.response = this.scanner.next();

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
		 	case "8":
		 		this.deleteBook();
	 		break;
		 	case "9":
		 		this.deleteUser();
	 		break;
		 	case "10":
		 		this.goBack();
	 		break;
	 		default:
	 			System.out.println("Sorry you may have enterd a wrong function \n");
	 			System.out.println("------------------------------------------------");
	 			this.showOptions();
		 }
		
	}


}
