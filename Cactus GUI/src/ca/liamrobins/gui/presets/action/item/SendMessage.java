package ca.liamrobins.gui.presets.action.item;

import org.bukkit.entity.Player;

import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

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
