import java.util.Scanner;

public class Guest {
	
	public int response;
	
	public Guest(){
		
		Scanner scanner = new Scanner(System.in);
		
		this.showOptions();
		this.handleResponse(scanner);
	}

	private void handleResponse(Scanner scanner) {
		this.response = scanner.nextInt();
		
		if(this.response == 0){
			this.SearchBookOptions(scanner);
			return;
		}
		if(this.response == 1){
			this.ViewBookOptions(scanner);
			return;
		}
		
		System.out.println("Sorry you may have entered a wrong function.");
	}

	private void ViewBookOptions(Scanner scanner) {
		System.out.println("Please enter BookID");
		
		String bookID = scanner.next();
		Book.view(bookID);
		
	}

	private void SearchBookOptions(Scanner scanner) {
		System.out.println("Please Enter Book Name");
		String bookName = scanner.next();
		Book.search(bookName);
		
		
	}

	private void showOptions() {
		System.out.println("Enter 0 to search a book.");
		System.out.println("Enter 1 to view book details.");
		
	}


}
