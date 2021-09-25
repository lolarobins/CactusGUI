package ca.cactusmc.gui.presets.action.item;

import org.bukkit.entity.Player;

import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.ItemAction;
import ca.cactusmc.gui.GUIItem;

/**
 * Sends a message to the player.
 * @author CCMW
 *
 */
public class SendMessage implements ItemAction {
	
	String message;
	
	/**
	 * Sends a message to the player that clicked.
	 * @param message Message to send to player.
	 */
	public SendMessage(String message) {
		this.message = message;
	}

	@Override
	public void run(Player player, CactusGUI gui, GUIItem item) {
		player.sendMessage(message);
	}
	
}
