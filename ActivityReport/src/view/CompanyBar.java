package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class CompanyBar extends JScrollPane{
	
	public static final String KILL_COM_ACTION_COMMAND = "killComButton";
	public static final String ASSIST_COM_ACTION_COMMAND = "assistComButton";
	public static final String GAMEMODE_COM_ACTION_COMMAND = "gamemodeComButton";
	
	private JButton killComButton;
	private JButton assistComButton;
	private JButton gamemodeComButton;
	//TODO Add more Buttons like Stats and other informations
	
	public CompanyBar(){
		super();
		this.killComButton = new JButton("Kill Commendations");
		this.killComButton.setActionCommand(KILL_COM_ACTION_COMMAND);
		
		this.assistComButton = new JButton("Assist Commendations");
		this.assistComButton.setActionCommand(ASSIST_COM_ACTION_COMMAND);
		
		this.gamemodeComButton = new JButton("Gamemode Commendations");
		this.gamemodeComButton.setActionCommand(GAMEMODE_COM_ACTION_COMMAND);
	}
	
	/**
	 * Sets the ActionLister for all Commendation Buttons
	 * 
	 * @param actionListener
	 */
	public void setCommendationHandler(ActionListener actionListener){
		killComButton.addActionListener(actionListener);
		assistComButton.addActionListener(actionListener);
		gamemodeComButton.addActionListener(actionListener);
	}
}
