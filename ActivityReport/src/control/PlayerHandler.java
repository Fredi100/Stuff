package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerHandler implements ActionListener{
	
	private Controller c;
	
	public PlayerHandler(Controller c){
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Tell the Logic what to do, when a player gets clicked.
	}

}
