import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class CommendationBot extends TelegramLongPollingBot {

	private String username;
	private String token;

	// public static final String username = "SpartanCompanyCommendationsBot";
	// public static final String token =
	// "220677609:AAER6G-whK-Jk5RHXE4sNxWSUHEAplkT1Tg";
	public static final Path pathToSettings = Paths.get("./", "settings.ini");

	public CommendationBot() {
		super();

		if (Files.notExists(pathToSettings, LinkOption.NOFOLLOW_LINKS)) {
			createDefaultSettingsFile();
		}
		readInSettings();
	}

	void createDefaultSettingsFile() {
		System.out.println("settings.ini file does not exist.");
		System.out.println("Trying to create it now.");
		try {
			Files.createFile(pathToSettings);
			byte[] bytes = new String("botname: \r\ntoken: ").getBytes();
			Files.write(pathToSettings, bytes);
		} catch (IOException e) {
			System.err.println("Creating \"settings.ini\" file failed!");
		}
	}

	void readInSettings() {
		try {
			List<String> fileContent;
			fileContent = Files.readAllLines(pathToSettings);
			for (String line : fileContent) {
				if(line.contains("botname")){
					setBotUsername(line.substring(9));
				}else if(line.contains("token")){
					setBotToken(line.substring(7));
				}else{
					System.err.println("Warning: \"setting\".ini contains a line not intended to be there.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
					.setText(update.getMessage().getText());
			try {
				sendMessage(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	public void setBotUsername(String username) {
		this.username = username;
	}

	public void setBotToken(String token) {
		this.token = token;
	}

	@Override
	public String getBotUsername() {
		return this.username;
	}

	@Override
	public String getBotToken() {
		return this.token;
	}

}
