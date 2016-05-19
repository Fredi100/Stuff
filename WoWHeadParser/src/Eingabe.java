import javax.swing.JOptionPane;

public class Eingabe {
	
	public static String getEingabe(String nachricht){
		return JOptionPane.showInputDialog(nachricht);
	}
}
