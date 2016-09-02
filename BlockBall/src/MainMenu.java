import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {

	private static MainMenu mainMenu;

	private JButton settings;
	private JButton about;
	private JButton quitGame;
	private JButton statistics;
	private JButton startGame;

	private static int gridLayoutWidth = 3;
	private static int gridLayoutHeight = 3;

	private MainMenu() {
		mainMenu = this;

		this.prepareLayout();
		this.prepareStartGameButton();
		this.prepareStatisticsButton();
		this.prepareQuitButton();
		this.prepareAboutButton();
		this.prepareSettingsButton();

	}

	private void prepareLayout() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
	}

	private void prepareSettingsButton() {
		// TODO Hier automatisierte Sprache verwenden
		settings = new JButton("Settings");
		GridBagConstraints settingsPosition = new GridBagConstraints();
		settingsPosition.gridx = 2;
		settingsPosition.gridy = 2;
		settingsPosition.gridheight = gridLayoutHeight / 3;
		settingsPosition.gridwidth = gridLayoutWidth / 3;
		this.add(settings, settingsPosition);
	}

	private void prepareAboutButton() {
		// TODO Hier automatisierte Sprache verwenden
		about = new JButton("About");
		GridBagConstraints aboutPosition = new GridBagConstraints();
		aboutPosition.gridx = 1;
		aboutPosition.gridy = 2;
		aboutPosition.gridheight = gridLayoutHeight / 3;
		aboutPosition.gridwidth = gridLayoutWidth / 3;
		this.add(about, aboutPosition);
	}

	private void prepareQuitButton() {
		// TODO Hier automatisierte Sprache verwenden
		quitGame = new JButton("Quit");
		GridBagConstraints quitPosition = new GridBagConstraints();
		quitPosition.gridx = 0;
		quitPosition.gridy = 2;
		quitPosition.gridheight = gridLayoutHeight / 3;
		quitPosition.gridwidth = gridLayoutWidth / 3;
		this.add(quitGame, quitPosition);
	}

	private void prepareStatisticsButton() {
		// TODO Hier automatisierte Sprache verwenden
		statistics = new JButton("Statistics");
		GridBagConstraints statisticsPosition = new GridBagConstraints();
		statisticsPosition.gridx = 0;
		statisticsPosition.gridy = 1;
		statisticsPosition.gridheight = gridLayoutHeight / 3;
		statisticsPosition.gridwidth = gridLayoutWidth;
		this.add(statistics, statisticsPosition);
	}

	private void prepareStartGameButton() {
		// TODO Hier automatisierte Sprache verwenden
		startGame = new JButton("Start Game");
		startGame.setPreferredSize(new Dimension(400, 200));
		GridBagConstraints startGamePosition = new GridBagConstraints();
		// TODO Diese Werte vielleicht auslagen und konstant irgendwo festlegen
		// TODO Vielleicht dieses stückchen code in eine Klasse auslagern
		startGamePosition.gridx = 0;
		startGamePosition.gridy = 0;
		startGamePosition.gridheight = gridLayoutHeight / 3;
		startGamePosition.gridwidth = gridLayoutWidth;
		this.add(startGame, startGamePosition);
	}

	public static MainMenu getMainMenu() {
		if (mainMenu == null) {
			mainMenu = new MainMenu();
		}
		return mainMenu;
	}

	public void addActionListener(MainMenuActionListener actionListener) {
		settings.addActionListener(actionListener);
		about.addActionListener(actionListener);
		quitGame.addActionListener(actionListener);
		statistics.addActionListener(actionListener);
		startGame.addActionListener(actionListener);
	}
}
