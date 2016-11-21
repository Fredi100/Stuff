package Emsenhuber;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;

public class CommandHandler extends TelegramLongPollingCommandBot{
	
	public CommandHandler(){
		register(new CheckCommand());
		register(new SetCompanyCommand());
		
		//registerDefaultAction(Hier eine lambda funktion);
	}

	@Override
	public String getBotUsername() {
		return Main.username;
	}

	@Override
	public void processNonCommandUpdate(Update arg0) {
		// TODO Hier Zeugs schreiben, dass gemacht werden kann, wenn kein Command kommt.
	}

	@Override
	public String getBotToken() {
		return Main.token;
	}

}
