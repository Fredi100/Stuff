package Emsenhuber;

import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

public class StartCommand extends BotCommand{
	
	public static final String LOGTAG = "STARTCOMMAND";
	
	public static final String identifier = "start";
	public static final String description = "With this command you can start the Bot.";

	public StartCommand() {
		super(identifier, description);
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
		
	}

}
