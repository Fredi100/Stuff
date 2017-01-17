package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	private static final String WINDOW_TITLE = "Activity Report";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 600;
	
	public ActivityMenuBar amb;
	private CardPanel cp;
	
	/**
	 * Window:
	 *   MenuBar
	 *   PlayerCard
	 *   CompanyCard
	 *   
	 * PlayerCard:
	 *   PlayerBar
	 *   PlayerPanel
	 *   
	 * CompanyCard:
	 *   CompanyBar
	 * 
	 * Das Window hat ein BorderLayout.
	 * Im North Teil befindet sich die MenuBar, diese bleibt dort.
	 * Im Center Teil befindet sich ein CardLayout.
	 * 
	 * Die erste Card ist die Company Card.
	 * Die zweite Card ist die Player Card.
	 * 
	 * Auf der Company Card befindet sich
	 * 
	 * Auf der Player Card befindet sich wieder in BorderLayout
	 * Im West Teil befindet sich die Player Bar
	 * Im Center Teil befindet sich das Player Panel mit all den Infos zum Spieler
	 */
	public Window(){
		super();
		this.setTitle(WINDOW_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.cp = new CardPanel();
		this.amb = new ActivityMenuBar();
		
		this.add(cp, BorderLayout.CENTER);
		this.add(amb,BorderLayout.NORTH);
	}
	
	/**
	 * Hands the given ActionListener over to the JMenuBar
	 * 
	 * @param al
	 */
	public void setMenuBarHandler(ActionListener al){
		this.amb.setActionListener(al);
	}
	
	/**
	 * Changes the Window to display the Player View
	 */
	public void displayPlayerView(){
		this.cp.displayPlayerCard();
	}
	
	/**
	 * Changes the Window to display the Company View
	 */
	public void displayCompanyView(){
		cp.displayCompanyCard();
	}
	
	public void setPlayerButtonHandler(ActionListener al){
		cp.setPlayerButtonHandler(al);
	}
	
	public void setCommendationHandler(ActionListener al){
		cp.setCommendationHandler(al);
	}
	
	public void addPlayerButton(String playerName){
		cp.addPlayerButton(playerName);
	}
	
	/**
	 * Refreshes the Window and all its components
	 */
	public void refreshWindow(){
		//TODO Refresh all component
		cp.refresh();
		this.revalidate();
	}
}
