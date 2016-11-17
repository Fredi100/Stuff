package core;

import java.util.ArrayList;

public class CommandQueue {

	ArrayList<Command> commandBuffer;

	public CommandQueue() {
		commandBuffer = new ArrayList<Command>(10);
	}

	public void queueCommand(Command cmd) {
		commandBuffer.add(cmd);
		
		// TODO Hier das empfangene Command in die Queue einf?gen
		// Muss immer das neueste Command hinten anstellen
		// Und das älteste Command dann ausliefern
	}

	public void sendCommands() {
		for (Command cmd : commandBuffer) {
			if (cmd != null){
				cmd.execute();
				commandBuffer.remove(cmd);
			}
		}
		commandBuffer.trimToSize();
	}

}
