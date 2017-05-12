
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class User {
	
	public String username;
	protected String password;
	public String role;
	public String ID;
	public FileSystem filesystem;
	public String firstname;
	public String lastname;
	public Scanner scanner;
	public String response;
	
	//Location where our text file will be stored
	protected final static String userFile = "user.txt";
	
	/**
	 * creates a new user
	 * @param username
	 * @param password
	 */
	public User(String username, String password){
		this.filesystem = new FileSystem(User.getFile());
		this.username = username;
		this.password = password;
		this.ID = generateID();
		this.scanner = new Scanner(System.in);
		this.showOptions();

	}
	
	public User(){
		this.scanner = new Scanner(System.in);
		this.showOptions();
	}
	
	
	/**
	 * recreates an extisting user
	 * @Override the constructor
	 * @param id
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param role
	 */
	public User(String id, String username, String password, String firstname, String lastname, String role) {
		this.ID = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.scanner = new Scanner(System.in);
	}
	

	private String generateID() {
		// TODO Auto-generated method stub
		return "3434343";
	}

	
	/**
	 * To string method for formatting the user object
	 */
	public String toString(){
		return "Watever";
		//return  this.getID() + " " +this.getName() + " " + this.getUsername() + " " + this.getPassword() +" " + this.getRole();
	}
	
	/**
	 * This will store the current user object to the file system
	 * 
	 */
	public void store() {
		try {
			System.out.println("Adding new user to file.....");
			filesystem.addObject(this);
			System.out.println("User was added successfully");
			
		} catch (IOException e) {
			System.out.println("Adding new user failed..");
			e.printStackTrace();
		}
	}
	

	/**
	 * Accepts credentials and then return the user if found
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static User login(String username, String password) {
		
		User user = null;
		try {
			
				String record = User.findBy(username + " " + password);
				
				if(record != ""){
					
					String[] userData = record.split("----");
					
					String id = userData[0];
					String firstname = userData[2];
					String lastname = userData[3];
					String role = userData[4];
					
					user = new User(id, username, password, firstname, lastname, role);
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return user;
	}

	/**
	 *  Finds a user by a specific column
	 *  This will return a string of the record
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public static String findBy(String word) throws IOException {
		
		return FileSystem.find(User.getFile(), word);
	}
	
	
	/**
	 * Returns the file if it exits and if it dosent we create a new one.
	 * 
	 * @return
	 */
	public static File getFile(){
		
		File f = new File(userFile);
		
		if(f.exists() == false){
			try {
				PrintWriter writer = new PrintWriter(userFile, "UTF-8");
				writer.println("id-username password-first_name-last_name-role-first_login-");
				writer.println("Schema!! Schema!! Schema!! Schema!! Schema!! Schema!! Schema!!");
				writer.println("-------------------------------------------------------------------------------------------");
				writer.close();
				f = User.getFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return f;
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

	/**
	 * 
	 */
	public void showOptions() {
		System.out.println("Enter 0 to search a book.");
		System.out.println("Enter 1 to view a book.");
		System.out.println("Enter 2 to go back.");
		
		this.response = this.scanner.nextLine();
		
		switch(this.response){
			case "0":
				this.searchBook();
				break;
			case "1":
				this.viewBook();
				break;
			case "2":
				this.goBack();
				break;
				default:
				System.out.println("Sorry you may have entered a wrong function.");
		}
	
	}
	
	public void viewBook() {
		
		System.out.println("Enter book ID");
		
		String ID = this.scanner.nextLine();
		
		Book book = Book.viewBy(ID);
		
		if(book != null){
			
			System.out.println("---------------------------------");
			System.out.println("Title: "+ book.title);
			System.out.println("Availability: "+ book.availability);
			System.out.println("Author: "+ book.author);
			System.out.println("Shelf Location: "+ book.shelve_no);
			this.showOptions();
			return;
		}
		
		System.out.println("Sorry Book was not found");
		System.out.println("---------------------------------");
		this.showOptions();
		
		
	}
	
	protected void goBack() {
		/**
		 * Instantiate main app class
		 */
		new App().kickstart();

		
	}
}
