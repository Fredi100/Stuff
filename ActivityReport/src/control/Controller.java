package control;

import view.Window;

public class Controller {

	public Controller() {
		Window w = new Window();
		PlayerHandler ph = new PlayerHandler(this);
		CommendationHandler ch = new CommendationHandler();
		//TODO Call the Logic and set everything necessary up
		
		w.pb.setPlayerButtonHandler(ph);
		w.cb.setCommendationHandler(ch);
	}

	public static void main(String[] args) {
		new Controller();
	}
}
