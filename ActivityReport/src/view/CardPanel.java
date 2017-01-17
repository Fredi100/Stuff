package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CardPanel extends JPanel{
	
	private PlayerCard pc;
	private CompanyCard cc;
	private CardLayout cl;
	
	public CardPanel(){
		super();
		cl = new CardLayout();
		this.setLayout(cl);
		
		pc = new PlayerCard();
		cc = new CompanyCard();
		
		this.add(cc,"company");
		this.add(pc,"player");
	}
	
	public void displayPlayerCard(){
		this.cl.show(this, "player");
	}
	
	public void displayCompanyCard(){
		this.cl.show(this, "company");
	}
	
	public void setPlayerButtonHandler(ActionListener al){
		this.pc.setPlayerButtonHandler(al);
	}
	
	public void setCommendationHandler(ActionListener al){
		this.cc.setCommendationHandler(al);
	}
	
	public void addPlayerButton(String playerName){
		this.pc.addPlayerButton(playerName);
	}
	
	public void refresh(){
		//TODO Refresh all components
		pc.refresh();
		cc.refresh();
	}
}
