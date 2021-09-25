package ca.cactusmc.gui;

import org.bukkit.plugin.java.JavaPlugin;

import ca.cactusmc.gui.event.GUIListener;

/**
 * Hooks CactusGUI library to a plugin.
 * @author CCMW
 */
public class CactusGUIHook {
	
	static JavaPlugin hook;

	/**
	 * Gets the plugin that is hooked with the library. For library use only (across multiple packages.)
	 * @return hooked plugin.
	 */
	public static JavaPlugin getHookedPlugin() {return hook;}
	
	/**
	 * Registers listeners and allows CactusGUI to work when it is included in the source of a plugin.
	 * <p>
	 * To prevent conflict, please only hook if CactusGUI is not installed on your server.
	 * @param plugin JavaPlugin to hook.
	 */
	public CactusGUIHook(JavaPlugin plugin) {
		hook = plugin;
		plugin.getServer().getPluginManager().registerEvents(new GUIListener(), plugin);
	}
	
}
