import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
	public static void main(String[] args) {
		System.out.println("Initialising Api Context");
		ApiContextInitializer.init();
		System.out.println("Creating Bot Api");
		TelegramBotsApi botsApi = new TelegramBotsApi();
		System.out.println("Registering Bot");
		try {
			botsApi.registerBot(new CommendationBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
