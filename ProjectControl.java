/*************************************************************************
 * 
 * 
 *  This is the control class that holds the main method
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class ProjectControl 
{

	 public static void main(String[] args) 
	 {
		Scanner option = new Scanner(System.in);
		int choice = 0;
		int filecount = 0;
		String filename = "";
		ArrayList<String> fileRead  = new ArrayList<String>();
		ArrayList<String> punctMarks = new ArrayList<String>();
		
		while(choice != 4){

		 System.out.print("Main Menu\n");
		 System.out.print("1. Open File\n");
		 System.out.print("2. Veify Language\n");
		 System.out.print("3. Display the top ten words\n");
		 System.out.print("4. Display whole file\n");
		 System.out.print("5. Filter unwanted words\n");
		 System.out.print("6. Exit\n");
		 System.out.print("Please select one of the following options: ");
		 
		 
		 choice = option.nextInt();

		 switch(choice)
		 {
		 	case 1:
		 		clearScreen();
		 		
		 		System.out.print("Please enter a filename: ");
		 		filename = option.next();
		 		
		 		FileManager read_1 = new FileManager("Z:\\Java\\R\\src\\punctuation.txt");
		 		FileManager read_2 = new FileManager("Z:\\Java\\R\\src\\" + filename + ".txt");
		 		
		 		read_1.connectToFile();
		 		read_2.connectToFile();
		 		
		 		punctMarks = read_1.readFile();
		 		fileRead = read_2.readFile();
		 		
		 		read_1.closeReadFile();
		 		read_2.closeReadFile();
		 		
		 		filecount++;
		 		System.out.println("File has been opened successfully");
		    	break;
		    
		 	case 2:
		 		clearScreen();
		 		
		 		if(filecount == 0)
		 		{
		 			System.out.println("No file was opened. Please open a file to correct this error:");
		 			
		 		}
		 		else
		 		{
		 			FindLan t3 = new FindLan(fileRead);
		 		 	t3.cLang();
		 		}
		 		break;
		 		
		 	case 3:
		 		clearScreen();
		 		
		 		if(filecount == 0)
		 		{
		 			System.out.println("No file was read. Please open a file to correct this error:");
		 			
		 		}
		 		else
		 		{
		 		
		 			//Creating the object for the remove punctuation class
		 			RemovePunct t1 = new RemovePunct(punctMarks, fileRead);
		    	
		 			//Calling the EndArray(Remove) method to clean an array of punctuation marks
		 			ArrayList<String> cleanWords = t1.EndArray();
		 			
		 			 for(int i=0; i<10; i++)
			    	 {
			    		System.out.println(cleanWords.get(i));
			    	 }
		 		}
		 		break;
		 	
		 	case 4:
		 		//clearScreen();
		 		
		 		//open the file
		 		FileManager read = new FileManager("Z:\\Java\\R\\src\\" + filename + ".txt");
		 		//connect to the file
		 		read.connectToFile();
		 		//read the lines and display them
		 		read.readLines();
		 		//close the file
		 		read.closeReadFile();
		 		//break so nothing happens after
		 		break;
		 	case 5:
		 		// enter word want to exclude
		 		System.out.print("Enter a word you want to exclude : ");
		 		//make a scanner object
		 		Scanner scanner = new Scanner(System.in);
		 		//get the string
		 		String word = scanner.nextLine();
		 		//print the string
		 		System.out.println(word);
		 		//open the file
		 		FileManager read1 = new FileManager("Z:\\Java\\R\\src\\" + filename + ".txt");
		 		//connect to the file
		 		read1.connectToFile();
		 		//read the lines and display them
		 		read1.readLines();
		 		//close the file
		 		read1.closeReadFile();
		 		//break so nothing happens after
		 		break;
		 		
		 	case 6:
		 		System.out.println("Thank You for Using Robo-Reader \n          Goodbye");
		 		System.exit(0);
		 		break;
		 	default:
		 		System.out.println("Option is not available");
		 	}

		}
		option.close();

	 }
	 
	 public static void clearScreen() {  
		    //System.out.print("\033[H\033[2J");  
		    System.out.flush();  
	 } 
	 
}

