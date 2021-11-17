package ca.liamrobins.gui.presets.action.item;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

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
