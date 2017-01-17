package control;

import view.Window;

public class Controller {
	
	private Window w;

	public Controller() {
		w = new Window();
		PlayerHandler ph = new PlayerHandler(this);
		CommendationHandler ch = new CommendationHandler();
		MenuBarHandler mbh = new MenuBarHandler(this);
		//TODO Call the Logic and set everything necessary up
		
		w.setPlayerButtonHandler(ph);
		w.setCommendationHandler(ch);
		w.amb.setActionListener(mbh);
		setPlayers();
		w.displayPlayerView();
		w.setVisible(true);
	}
	
	public void addPlayer(String gamertag){
		//TODO Change to add the Players to the logic
		w.addPlayerButton(gamertag);
		w.refreshWindow();
	}
	
	//TODO Just temporarily
	private void setPlayers(){
		addPlayer("Test1");
		addPlayer("Test2");
		addPlayer("Test3");
		addPlayer("Test4");
		addPlayer("Test5");
	}

	public static void main(String[] args) {
		new Controller();
		/*
		try {
			String stats = playerMatches("Fredi100");
			//JsonParser.parseString(stats);
		} catch (IOException e) {
			e.printStackTrace();
		}/* catch (ParseException e) {
			e.printStackTrace();
		}*/
	}
}
