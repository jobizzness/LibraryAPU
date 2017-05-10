
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 
	 * @param file
	 * @param object
	 * @return
	 * @throws IOException 
	 */
	public static boolean modify(File file, Object oldObject, Object newObject) throws IOException{
		
		URI location = file.toURI(); 
		
		System.out.println(oldObject.toString());
		
		System.out.println(newObject.toString());
		
		List<String> newLines = new ArrayList<>();
		for (String line : Files.readAllLines(Paths.get(location), StandardCharsets.UTF_8)) {
		    if (line.contains(oldObject.toString())) {
		       newLines.add(line.replace(oldObject.toString(), newObject.toString()));
		    } else {
		       newLines.add(line);
		    }
		}
		Files.write(Paths.get(location), newLines, StandardCharsets.UTF_8);
		return false;

	}
	
	
	
	public static boolean removeObject(File file, Object object) throws IOException
    {

            BufferedReader br = new BufferedReader(new FileReader(file));

            List<String> linestoadd = new ArrayList<String>();
            while(br.ready())
            {
                String line = br.readLine();
                if(!line.trim().equals(object.toString()))
                {
                    linestoadd.add(line.trim());
                }
                else
                {
                    return false;
                }
            }
            br.close();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for(String linetoadd : linestoadd)  
            {
                pw.println(linetoadd);
            }
            pw.close();
            return true;      


    }
}
