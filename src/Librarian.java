import java.io.IOException;

public class Librarian extends User{

	
	public Librarian(User user) {
		
		super(user.ID, user.username, user.password, user.firstname, user.lastname, user.role);
		this.showOptions();

	}
	

	public void searchBook() {

		System.out.println("Enter book Title");
		
		String title = this.scanner.nextLine();
		
		Book book = Book.viewBy(title);
		
		if(book != null){
			
			System.out.println("Book Found:");
			System.out.println("---------------------------------");
			System.out.println("Title: "+ book.title);
			System.out.println("Availability: "+ book.availability);
			System.out.println("Author: "+ book.author);
			System.out.println("Shelf Location: "+ book.shelve_no);
			this.showOptions();
			return;
		}
		System.out.println("Sorry No result Found");
		System.out.println("---------------------------------");
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


	
	public void showOptions() {

		
		System.out.println("Enter 0 to search a book");
		System.out.println("Enter 1 to view a book");
		System.out.println("Enter 2 to add a new book");
		System.out.println("Enter 3 to modify a book");
		System.out.println("Enter 4 for checkIn");
		System.out.println("Enter 5 for checkOut");
		System.out.println("Enter 6 for reporting");
		System.out.println("Enter 7 to go back");
		
		this.response = this.scanner.next();

		 switch(response){
		 	case "0":
		 		this.searchBook();
	 		break;
		 	case "1":
		 		this.viewBook();
	 		break;
		 	case "3":
		 		this.modifyBook();
	 		break;
		 	case "4":
		 		this.checkIn();
	 		break;
		 	case "5":
		 		this.checkOut();
	 		break;
		 	case "6":
		 		this.reporting();
	 		break;
		 	case "7":
		 		this.goBack();
	 		break;
	 		default:
	 			System.out.println("Sorry you may have enterd a wrong function \n");
	 			System.out.println("------------------------------------------------");
	 			this.showOptions();
		 }
		
	}


}
