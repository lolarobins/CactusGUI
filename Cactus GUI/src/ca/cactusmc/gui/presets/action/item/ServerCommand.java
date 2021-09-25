package ca.cactusmc.gui.presets.action.item;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.ItemAction;
import ca.cactusmc.gui.GUIItem;

/**
 * Runs a command from the server console.
 * @author CCMW
 *
 */
public class ServerCommand implements ItemAction {

	String command;
	
	/**
	 * Runs a server command when clicked.
	 * @param command Command to run.
	 */
	public ServerCommand(String command) {
		this.command = command;
	}
	
	@Override
	public void run(Player player, CactusGUI gui, GUIItem item) {
		Bukkit.dispatchCommand(player, command);
	}
	
}
