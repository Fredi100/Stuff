import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private static Window window;

	public enum WindowComponent {
		MAINMENU, GAMESCREEN, SETTINGSCREEN
	}

	/**
	 * Constructor is private, so that i can determine when a new Window Object
	 * gets created
	 */
	private Window() {
		window = this;
	}

	/**
	 * Used to create a new or get the existing Window Object
	 * 
	 * @return A newly generated or the existing Window Object
	 */
	public static Window getWindow() {
		if (window == null) {
			window = new Window();
		}
		return window;
	}

	public void displayGivenWindowComponent(WindowComponent wc) {
		switch (wc) {
		case MAINMENU:
			this.prepareMainMenu();
			break;
		case GAMESCREEN:
			this.prepareGameScreen();
			break;
		case SETTINGSCREEN:
			this.prepareSettingScreen();
		}
	}

	// TODO Diesen batzen hier vereinfachen, indem die ganzen Screens eine
	// gemeinsame abstrakte Klasse bekommen. Dann kann eine Funktion individuell auf alle
	// Screens aggieren.
	private void prepareSettingScreen() {
		SettingScreen settingScreen = SettingScreen.getSettingScreen();
		this.removeAll();
		this.add(settingScreen);
	}

	private void prepareGameScreen() {
		GameScreen gameScreen = GameScreen.getGameScreen();
		this.removeAll();
		this.add(gameScreen);
	}

	private void prepareMainMenu() {
		MainMenu mainMenu = MainMenu.getMainMenu();
		this.removeAll();
		this.add(mainMenu);
	}
	
	public void displayWindow(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Spiel");
		this.setSize(400, 800);
		this.setVisible(true);
	}

}
