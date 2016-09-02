import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SettingScreen extends JPanel {
	private static SettingScreen settingScreen;

	private SettingScreen() {
		settingScreen = this;
	}

	public static SettingScreen getSettingScreen() {
		if (settingScreen == null) {
			new SettingScreen();
		}
		return settingScreen;
	}
}
