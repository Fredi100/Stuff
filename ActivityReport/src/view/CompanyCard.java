package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CompanyCard extends JPanel{
	
	private CompanyBar cb;
	
	public CompanyCard(){
		super();
		this.setLayout(new BorderLayout());
		
		this.cb = new CompanyBar();
		
		this.add(cb, BorderLayout.WEST);
	}
	
	public void refresh(){
		//TODO Refresh all components
	}
	
	public void setCommendationHandler(ActionListener al){
		cb.setCommendationHandler(al);
	}
}
