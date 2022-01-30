package mypackages;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Lockedme
{
	static final String projectFilesPath = "D:\\SL\\LockedMeFiles";
	static final String errorMessage = "some error occured. Plese contact : admin@lockedme.com ";

	public static void main(String[] args) 
	{ 
		Scanner obj = new Scanner(System.in);
		 int ch;
		 do
		{
			displayMenu();
			System.out.println("Enter your choice:"); 
			ch=Integer.parseInt(obj.nextLine());
			switch(ch)
			{
			case 1:getAllFiles();
			ch=1;
			break;
			case 2:createFiles();
			ch=2;
			break;
			case 3:deleteFiles();
			ch=3;
			break;
			case 4:searchFiles();
			ch=4;
			break;
			case 5:System.exit(0);
			ch=5;
			break;
			default:
				System.out.println("Invalid Option");
			break;
			
			}
		}
		while(ch==1);
		obj.close();
		
	}
	public static void displayMenu()
	 {
		 System.out.println("==================================================================");
		 System.out.println("\t\tWelcome to Lockedme.com");
		 System.out.println("==================================================================");
		 System.out.println("created by chandra.mounika");
		 System.out.println("\t\t1. Display all the files");
		 System.out.println("\t\t2. Add a new file");
		 System.out.println("\t\t3. Delete a file");
		 System.out.println("\t\t4. Search a file");
		 System.out.println("\t\t5. Exit");

	 }
	  /**
	   * This function will return all the files from the project directory
	   */
     public static void getAllFiles()
     {
    	 try
    	 {
    		File folder = new File(projectFilesPath);
    		File[] listofFiles = folder.listFiles();
    		
    		if(listofFiles.length==0)
    			System.out.println("No files exist in the directory");
    		else
    		{
    			for(var l:listofFiles)
    			{
    				System.out.println(l.getName());
    			}
    		}
    	 }
    	 catch(Exception Ex)
    	 {
    		 System.out.println(errorMessage);
    	 }
    	 
    }
     /**
      * This create a new file
      */
     public static void createFiles()
     { 
    	 Scanner obj = new Scanner(System.in);
        try
        {
        	
        	String fileName;
        	System.out.println("Enter file name:");
        	fileName = obj.nextLine();
        	
        	int linesCount;
        	System.out.println("Enter how many lines in the file");
        	linesCount=Integer.parseInt(obj.nextLine());
        	
        	
        	FileWriter myWriter = new FileWriter(projectFilesPath+"\\"+ fileName);
        	for(int i=1;i<=linesCount;i++)
        	{
        		System.out.println("Enter how many lines in the file");
        		myWriter.write(obj.nextLine()+"\n");
        	}
        	System.out.println("File created successfully");
        	myWriter.close();
        	obj.close();
        
        }
        catch(Exception Ex)
        {
          System.out.println(errorMessage);	
        }
    	
     }
     /**
      * This method will delete file based on provided file name
      */
     public static void deleteFiles()
     { 
    	 Scanner obj = new Scanner(System.in);
    	 try
    	 {
    	 String fileName;
    	 
    	 System.out.println("Enter the final name to be deleted:");
    	 
    	 fileName = obj.nextLine();
    	 
    	 File file = new File(projectFilesPath+"\\"+ fileName);
    	 
    	 if(file.exists())
    	 {
    		 file.delete();
    		 System.out.println("File deleted successfully : "+fileName);
    	 }
    	 else
    		 System.out.println("File do not exist");
    	 }
 		 catch(Exception Ex)
    	 {
 			 System.out.println(errorMessage);
    	 }
    	 finally
    	 {
    		 obj.close();
    	 }
 		 
     }
     /**
      * This method will search files from the directory
      */
     public static void searchFiles()
     {
    	 Scanner obj = new Scanner(System.in);
    	 try
    	 {
    	 String fileName;
    	 
    	 System.out.println("Enter the final name to be searched:");
    	 
    	 fileName = obj.nextLine();
    	 
    	 File folder = new File(projectFilesPath);
 		 File[] listofFiles = folder.listFiles();
 		
 		 LinkedList<String> filenames = new LinkedList<String>();
 		 
 		 for(var l:listofFiles)
 		   
 			 filenames.add(l.getName());
 		 
 		 if(filenames.contains(fileName))
 			 
 			 System.out.println("File available");
 		 else
 			 System.out.println("File is not available");
    	 }
    	  catch(Exception Ex)
    	 {
 			 System.out.println(errorMessage);
    	 }
    	 finally
    	 {
    		 obj.close();
    	 } 
     }
}  

