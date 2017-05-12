import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Book {

	public String id;
	public String title;
	public Boolean availability;
	public String author;
	public String shelve_no;
	
	//Location where our text file will be stored
	private final static String bookFile = "book.txt";

	/**
	 * Constructor
	 * @param id
	 * @param title
	 * @param availability
	 * @param author
	 * @param shelve_no
	 */
	public Book(String id, String title, Boolean availability, String author, String shelve_no){
		
		this.id = id;
		this.title = title;
		this.availability = availability;
		this.author = author;
		this.shelve_no = shelve_no;
	}

	
	public String toString(){

		return this.id+ "----" + this.title + "----"+ this.availability + "----"+ this.author + "----"+ this.shelve_no;
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public static Book search(String word) {
		
		try {
			String record = FileSystem.find(Book.getFile(), word);
			
			
			if(record != ""){
				String[] data = record.split("----");
				
				String id = data[0];
				String title = data[1];
				Boolean availability = Boolean.valueOf(data[2]);
				String author = data[3];
				String shelve_no = data[4];
				
				return new Book(id, title, availability, author, shelve_no);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void reportAll() {
	
		try {
			
			ArrayList<String> records = FileSystem.getContents(Book.getFile());
			
			for(String record : records){
				System.out.println(record);
			}

			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
	public static Book viewBy(String id){

		try {
			
			String record = FileSystem.find(Book.getFile(), id);
			
			if(record != ""){
				String[] data = record.split("----");
				
				String title = data[1];
				Boolean availability = Boolean.valueOf(data[2]);
				String author = data[3];
				String shelve_no = data[4];
				
				return new Book(id, title, availability, author, shelve_no);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns the file if it exits and if it dosent we create a new one.
	 * 
	 * @return
	 */
	public static File getFile(){
		
		File f = new File(bookFile);
		
		if(f.exists() == false){
			try {
				PrintWriter writer = new PrintWriter(bookFile, "UTF-8");
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

}
