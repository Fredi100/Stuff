import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileHandler {
	
	public static ArrayList<String> readFile(String path){
		ArrayList<String> list = new ArrayList<String>();
		try{
		Scanner s = new Scanner(new File(path));
		list = new ArrayList<String>();
		while (s.hasNextLine()){
		    list.add(s.nextLine());
		}
		s.close();
		return list;
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null,"The given file was not found!");
		}catch(Exception e){
			list = new ArrayList<String>();
			e.printStackTrace();
		}
		return list;
	}
	
	public static void exportFile(String output, String path) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(path)));
		pw.write(output);
		pw.close();
	}
}
