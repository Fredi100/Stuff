package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	private static final String WINDOW_TITLE = "Activity Report";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 600;
	
	public PlayerBar pb;
	public CompanyBar cb;
	
	public Window(){
		this.setTitle(WINDOW_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.pb = new PlayerBar();
		this.cb = new CompanyBar();
	}
	
	public void displayPlayerView(){
		this.add(pb,BorderLayout.WEST);
		//TODO Add everything for the Player View
	}
	
	public void displayCompanyView(){
		//TODO Add everything for the Company View
	}
	
	public void refreshWindow(){
		this.pb.refresh();
		this.revalidate();
	}
}
