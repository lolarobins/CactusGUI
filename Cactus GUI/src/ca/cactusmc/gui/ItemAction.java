package ca.cactusmc.gui;

import org.bukkit.entity.Player;

/**
 * Use to define an action for a GUI with a specific item.
 * @see GUIAction
 * @author CCMW
 */
@FunctionalInterface
public interface ItemAction {	
	/**
	 * Similar to Runnable, the overrided run void will be called.
	 * @param player Player that clicked on an item.
	 * @param gui The GUI that was clicked on.
	 * @param item The item that was clicked.
	 */
	public abstract void run(Player player, CactusGUI gui, GUIItem item);

}
