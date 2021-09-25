package ca.cactusmc.gui;

import org.bukkit.entity.Player;

/**
 * Use to define an action for a GUI.
 * @see GUIAction
 * @author CCMW
 */
@FunctionalInterface
public interface GUIAction {	
	/**
	 * Similar to Runnable, the overrided run void will be called.
	 * @param player Player to affect.
	 * @param gui The GUI involved in action.
	 */
	public abstract void run(Player player, CactusGUI gui);

}

