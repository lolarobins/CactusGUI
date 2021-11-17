package ca.liamrobins.gui.presets.action.item;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

/**
 * Runs a specified command from the player.
 * @author CCMW
 */
public class PlayerCommand implements ItemAction {

	String command;
	
	/**
	 * Runs a command (player that clicked as sender).
	 * @param command Command to run.
	 */
	public PlayerCommand(String command) {
		this.command = command;
	}
	
	@Override
	public void run(Player player, CactusGUI gui, GUIItem item) {
		Bukkit.dispatchCommand(player, command);
	}
}
