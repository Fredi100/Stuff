import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	
	//Center-Stuff
	private JTextArea sqlOutput;
	
	//Bottom-Stuff
	private JPanel bottom;
	public JTextField eingabe;
	private JLabel errors;
	
	public Gui(Control c){
		this.setTitle("WoWHead-Parser");
		this.setLayout(new BorderLayout());
		this.sqlOutput = new JTextArea();
		this.sqlOutput.setEditable(false);
		this.add(this.sqlOutput,BorderLayout.CENTER);
		
		this.bottom = new JPanel(new GridLayout(2,1));
		this.eingabe = new JTextField();
		this.eingabe.setActionCommand("eingabeFeld");
		this.eingabe.addKeyListener(c);
		
		this.errors = new JLabel("Bitte einfach dein Link zum Spell einfügen und Enter drücken!");
		
		this.bottom.add(errors);
		this.bottom.add(eingabe);
		
		this.add(bottom, BorderLayout.SOUTH);
		
		//Zum Schluss
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public JTextField getEingabe(){
		return this.eingabe;
	}
	
	public void setOutput(String output){
		this.sqlOutput.append(output);
	}
	
	public void setError(String error){
		this.errors.setText(error);
	}
}
