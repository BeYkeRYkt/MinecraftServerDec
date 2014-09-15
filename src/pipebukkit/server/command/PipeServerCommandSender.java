package pipebukkit.server.command;

import org.bukkit.ChatColor;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;

public class PipeServerCommandSender extends ServerCommandSender {

	@Override
	public String getName() {
		return "CONSOLE";
	}

	@Override
	public void sendMessage(String message) {
		sendRawMessage(message);
	}

	@Override
	public void sendMessage(String[] messages) {
		for (String message : messages) {
			sendMessage(message);
		}
	}

	@Override
	public boolean isOp() {
		return true;
	}

	@Override
	public void setOp(boolean op) {
	}

	@Override
	public void abandonConversation(Conversation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptConversationInput(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean beginConversation(Conversation arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConversing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendRawMessage(String message) {
		System.out.println(ChatColor.stripColor(message));
	}

}
