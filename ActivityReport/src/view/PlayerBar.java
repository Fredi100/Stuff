package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PlayerBar extends JScrollPane{
	private TreeMap<String,JButton> playerButtons;
	
	private JPanel content;
	
	private static final int PREFERRED_WIDTH = 60;
	private static final int PREFERRED_HEIGHT = 500;
	
	//TODO Get this working
	public PlayerBar(){
		this.setPreferredSize(new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT));
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		content = new JPanel();
		this.add(content);
		
		this.playerButtons = new TreeMap<String,JButton>();
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	/**
	 * Adds all PlayerButtons to the JScrollBar so they are visible for the User
	 */
	public void refresh(){
		this.content.removeAll();
		for(JButton b : playerButtons.values()){
			this.content.add(b);
		}
	}
	
	/**
	 * Adds a new PlayerButton for the given PlayerName to the List of PlayerButtons.
	 * 
	 * @param playerName The name of the new Player
	 */
	public void addPlayer(String playerName){
		JButton player = new JButton(playerName);
		player.setActionCommand(playerName);
		player.setPreferredSize(new Dimension(50,20));
		playerButtons.put(playerName, player);
	}
	
	/**
	 * Sets the Handler for every PlayerButton
	 * 
	 * @param playerButtonHandler The handler for all PlayerButtons
	 */
	public void setPlayerButtonHandler(ActionListener playerButtonHandler){
		for(JButton b : playerButtons.values()){
			b.addActionListener(playerButtonHandler);
		}
	}
}
