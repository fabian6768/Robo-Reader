import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class filechoser {
	//Declare Var
	String userhome = System.getProperty("user.home");
	//JFileChooser fc = new JFileChooser(userhome +"\\Music");
	JFileChooser fileChooser = new JFileChooser(userhome +"\\Desktop");
	ArrayList<String> words = new ArrayList<String>();
	
	public ArrayList<String> PickMe() throws Exception{
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			java.io.File file = fileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
			
			while(input.hasNext()){
				words.add(input.next());
			}
			
			input.close();
			return words;
		}
		else{
			System.out.println("ERROR : FILE NOT CHOSEN");
		}
		return words;
	}
}
