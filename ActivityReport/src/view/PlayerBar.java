package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PlayerBar extends JScrollPane {
	private TreeMap<String, JButton> playerButtons;

	private JPanel content;

	private static final int PREFERRED_WIDTH = 60;
	private static final int PREFERRED_HEIGHT = 500;

	// TODO Get this working
	public PlayerBar() {
		super();
		this.setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
		content = new JPanel(new GridLayout(100,1));
		this.add(content);

		this.playerButtons = new TreeMap<String, JButton>();
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	/**
	 * Adds all PlayerButtons to the JScrollBar so they are visible for the User
	 */
	public void refresh() {
		this.content.removeAll();
		this.content.setLayout(new GridLayout(playerButtons.size(), 1));
		for (JButton b : playerButtons.values()) {
			this.content.add(b);
		}
		for(JButton play : playerButtons.values()){
			System.out.println(play.getActionCommand());
		}
	}

	/**
	 * Adds a new PlayerButton for the given PlayerName to the List of
	 * PlayerButtons.
	 * 
	 * @param playerName
	 *            The name of the new Player
	 */
	public void addPlayerButton(String playerName) {
		if (playerName != null && !playerName.equals("")) {
			JButton player = new JButton(playerName);
			player.setActionCommand(playerName);
			player.setPreferredSize(new Dimension(50, 20));
			playerButtons.put(playerName, player);
		}
	}

	/**
	 * Sets the Handler for every PlayerButton
	 * 
	 * @param playerButtonHandler
	 *            The handler for all PlayerButtons
	 */
	public void setPlayerButtonHandler(ActionListener playerButtonHandler) {
		for (JButton b : playerButtons.values()) {
			b.addActionListener(playerButtonHandler);
		}
	}
}
