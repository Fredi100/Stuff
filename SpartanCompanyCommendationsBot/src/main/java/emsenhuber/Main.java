package emsenhuber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

	public static String username;
	public static String token;

	public static String spartanCompany = "";

	public static final Path pathToSettings = Paths.get("./", "settings.ini");
	public static final String killCommendationURL = "https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/commendations/7e7e9e23-546e-4d1c-a4a1-2df467ad57ac/spartan-companies/";
	public static final String assistCommendationURL = "https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/commendations/159c73ad-6c70-41c0-a303-ff36602d0ed3/spartan-companies/";
	public static final String gamemodeCommendationURL = "https://www.halowaypoint.com/en-us/games/halo-5-guardians/xbox-one/commendations/1e319878-93c1-41b0-b7bc-8219fe1e319f/spartan-companies/";

	/**
	 * Reads the Bot-Username and the Token from the settings file.
	 */
	static void readInSettings() {
		try {
			List<String> fileContent;
			fileContent = Files.readAllLines(pathToSettings);
			for (String line : fileContent) {
				if (line.contains("botname")) {
					username = line.substring(9);
				} else if (line.contains("token")) {
					token = line.substring(7);
				} else {
					System.err.println("Warning: \"setting\".ini contains a line not intended to be there.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a default settings file if no settings file exists.
	 */
	static void createDefaultSettingsFile() {
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

	public static void main(String[] args) {
		if(Files.notExists(pathToSettings)){
			createDefaultSettingsFile();
		}
		readInSettings();
		System.out.println("Initialising Api Context");
		ApiContextInitializer.init();
		System.out.println("Creating Bot Api");
		TelegramBotsApi botsApi = new TelegramBotsApi();
		System.out.println("Registering Bot");
		try {
			botsApi.registerBot(new CommandHandler());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
