
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileSystem {
	
	/**
	 * Current file we are working with
	 * @file
	 */
	private File file;
	
	/**
	 * FileSystem Constructor
	 * @param file
	 */
	  public FileSystem(File file) {
		  this.file = file;
	}

	/**
	   * 
	   * Responsible for adding objects to file.
	   * 
	   * @param file
	   * @param object
	   * @return
	   * @throws IOException
	   */
	  public boolean addObject(Object object) throws IOException
	    {

	            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
	            pw.println(object.toString());
	            pw.close();
	            return true;

	    }

	
	/**
	 * Checks if a word exists in a file.
	 * Returns an empty string if not found
	 * 
	 * @throws IOException 
	 *   
	 */
	public static String find(File file, String word) throws IOException{
		
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 
		 String line = br.readLine();
         while(line != null)
         {
             String[] wordsinLine = line.split("-");
             
             	for (String wordfound: wordsinLine){
             		if(wordfound.equals(word)){
             			return line;
             		}
             	}
             	line = br.readLine();
         }

         return "";
	}
}
