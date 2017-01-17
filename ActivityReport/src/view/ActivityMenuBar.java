package view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Represents the MenuBar on the top of the Window.
 * Contains various Menus.
 * For more information about those Menus read there documentation.
 * 
 * @author Fredi100
 * @version 2016-12-01
 */
@SuppressWarnings("serial")
public class ActivityMenuBar extends JMenuBar{
	
	JMenu fileMenu;
	JMenuItem newPlayerItem;// A Menu to add a new Player to the list of Company Members
	//TODO Add more JMenus
	
	public ActivityMenuBar(){
		fileMenu = new JMenu("File");
		newPlayerItem = new JMenuItem("Add Player");
		
		setActionCommands();
		prepare();
	}
	
	/**
	 * Tells every JMenu what there ActionCommand is
	 */
	private void setActionCommands(){
		newPlayerItem.setActionCommand("newPlayerItem");
	}
	
	/**
	 * Assigns the given ActionListener to every JMenu
	 * 
	 * @param al
	 */
	public void setActionListener(ActionListener al){
		newPlayerItem.addActionListener(al);
	}
	
	/**
	 * Prepares the JMenuBar
	 */
	private void prepare(){
		/* Add MenuItems to Menus */
		fileMenu.add(newPlayerItem);
		
		/* Add Menus to MenuBars */
		this.add(fileMenu);
	}
}
