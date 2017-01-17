package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PlayerCard extends JPanel{
	
	private PlayerBar pb;
	private PlayerPanel pp;
	
	public PlayerCard(){
		super();
		this.setLayout(new BorderLayout());
		
		this.pb = new PlayerBar();
		this.pp = new PlayerPanel();
		
		this.add(pb, BorderLayout.WEST);
		this.add(pp,BorderLayout.CENTER);
	}
	
	public void setPlayerButtonHandler(ActionListener al){
		pb.setPlayerButtonHandler(al);
	}
	
	public void addPlayerButton(String playerName){
		pb.addPlayerButton(playerName);
	}
}
