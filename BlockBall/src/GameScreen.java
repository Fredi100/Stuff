import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	private static GameScreen gameScreen;

	private GameScreen() {
		gameScreen = this;
	}

	public static GameScreen getGameScreen() {
		if (gameScreen == null) {
			new GameScreen();
		}
		return gameScreen;
	}
}
