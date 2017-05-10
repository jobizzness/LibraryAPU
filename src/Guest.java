import java.util.Scanner;

public class Guest {
	
	public String response;
	
	public Guest(){
		
		Scanner scanner = new Scanner(System.in);
		
		this.showOptions();
		this.handleResponse(scanner);
	}
	
	/**
	 * 
	 * @param scanner
	 */
	private void handleResponse(Scanner scanner) {
		this.response = scanner.nextLine();
		
		if(this.response.equalsIgnoreCase("0")){
			this.SearchBookOptions(scanner);
			return;
		}
		if(this.response.equalsIgnoreCase("1")){
			this.ViewBookOptions(scanner);
			return;
		}
		
		System.out.println("Sorry you may have entered a wrong function.");
	}

	/**
	 * 
	 * @param scanner
	 */
	private void ViewBookOptions(Scanner scanner) {
		System.out.println("Please enter BookID");
		
		String bookID = scanner.nextLine();
		Book.view(bookID);
		
	}

	/**
	 * 
	 * @param scanner
	 */
	private void SearchBookOptions(Scanner scanner) {
		System.out.println("Please Enter Book Name");
		String bookName = scanner.nextLine();
		Book book = Book.search(bookName);
		
		if(book != null){
			book.display();
			return;
		}
		
		System.out.println("Sorry no results found");
	}
	
	/**
	 * 
	 */
	private void showOptions() {
		System.out.println("Enter 0 to search a book.");
		System.out.println("Enter 1 to view book details.");
	}


}
