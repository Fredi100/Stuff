package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Fredi100
 * @version 2016-12-01
 */
@SuppressWarnings("serial")
public class PlayerPanel extends JPanel{
	
	JLabel nameLabel, gamesLabel, testLabel;
	JTextField nameField, gamesField, testField;
	
	public PlayerPanel(){
		super();
		this.setLayout(new GridLayout(3,2));
		
		nameLabel = new JLabel("Gamertag:");
		gamesLabel = new JLabel("Games played this week:");
		testLabel = new JLabel("TestLabel:");
		
		nameField = new JTextField();
		gamesField = new JTextField();
		testField = new JTextField();
		
		prepare();
	}
	
	private void prepare(){
		this.add(nameLabel);
		this.add(nameField);
		this.add(gamesLabel);
		this.add(gamesField);
		this.add(testLabel);
		this.add(testField);
	}
}
