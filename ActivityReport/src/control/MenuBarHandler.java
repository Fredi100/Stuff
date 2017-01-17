package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MenuBarHandler implements ActionListener{
	
	Controller c;
	
	public MenuBarHandler(Controller c){
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand() == "newPlayerItem"){
			//TODO Open JOptionPane for Input of the new GamerTag
			String gamertag = JOptionPane.showInputDialog("Please enter the Gamertag of the new Company Member.");
			c.addPlayer(gamertag);
		}
	}

}
