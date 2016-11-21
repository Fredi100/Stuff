package emsenhuber;

import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;

public class CheckCommand extends BotCommand {
	
	public static final String identifier = "check";
	public static final String description = "Checks all Commendations fo the set Spartan Company.";

	public CheckCommand() {
		super(identifier, description);
	}

	@Override
	public void execute(AbsSender arg0, User arg1, Chat arg2, String[] arg3) {
		// TODO Check all the commendations and print them
	}

}
