package Emsenhuber;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class SetCompanyCommand extends BotCommand {
	
	private static final String LOGTAG = "SETCOMPANYCOMMAND";

	public static final String identifier = "setCompany";
	public static final String description = "Used to set the Spartan Company whose Commendations should be checked.";

	public SetCompanyCommand() {
		super(identifier, description);
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		if (arguments != null && arguments.length > 0) {
			System.out.println("");
			Main.spartanCompany = arguments[0];
		}else{
			SendMessage answer = new SendMessage();
			answer.setText("You forgot to append the Spartan Company name.");
			try{
				absSender.sendMessage(answer);
			}catch(TelegramApiException e){
				e.printStackTrace();
			}
		}
	}
}
