package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CompanyBar;

public class CommendationHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case CompanyBar.KILL_COM_ACTION_COMMAND:
			//TODO Tell the Logic to fetch all Kill Commendation Informations
			break;
		case CompanyBar.ASSIST_COM_ACTION_COMMAND:
			//TODO Tell the Logic to fetch all Assist Commendation Informations
			break;
		case CompanyBar.GAMEMODE_COM_ACTION_COMMAND:
			//TODO Tell the Logic to fetch all Gamemode Commendation Informations
			break;
		default:
			//TODO Handle the default Event
			break;
		}
	}
}
