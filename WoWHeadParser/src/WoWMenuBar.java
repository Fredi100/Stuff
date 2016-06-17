import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class WoWMenuBar extends JMenuBar{
	
	public static String ACTION_COMMAND_OPEN = "MenuOpen";
	public static String ACTION_COMMAND_EXPORT = "MenuExport";
	public static String ACTION_COMMAND_ABOUT = "MenuAbout";
	public static String ACTION_COMMAND_CONTACT = "MenuContact";
	
	private JMenu file;
	private JMenu help;
	
	private JMenuItem openFile;
	private JMenuItem exportFile;
	
	private JMenuItem about;
	private JMenuItem contact;
	
	public WoWMenuBar(Control c){
		
		/* File Menu */
		
		// Creating the Menu
		file = new JMenu("File");
		
		// File MenuItems
		openFile = new JMenuItem("Open File");
		openFile.setActionCommand(ACTION_COMMAND_OPEN);
		openFile.addActionListener(c);
		exportFile = new JMenuItem("Export SQL");
		exportFile.setActionCommand(ACTION_COMMAND_EXPORT);
		exportFile.addActionListener(c);
		
		// Adding the MenuItems to the Menu
		file.add(openFile);
		file.add(exportFile);
		
		// Adding the Menu to the MenuBar
		add(file);
		
		/* Help Menu */
		
		// Creating the Menu
		help = new JMenu("Help");
		
		// Help MenuItems
		contact = new JMenuItem("Contact");
		contact.setActionCommand(ACTION_COMMAND_CONTACT);
		contact.addActionListener(c);
		about = new JMenuItem("About");
		about.setActionCommand(ACTION_COMMAND_ABOUT);
		about.addActionListener(c);
		
		// Adding the MenuItems to the Menu
		help.add(contact);
		help.add(about);
		
		// Adding the Menu to the MenuBar
		this.add(help);
	}
}
