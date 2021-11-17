package ca.liamrobins.gui.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import ca.liamrobins.gui.CactusGUIHook;

/**
 * CactusGUI for library use. Should only be used in worst case scenario where it cannot be added as a library to other plugins.
 * @author CCMW
 */
public class CGUIJavaPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		new CactusGUIHook(this);
		
		getCommand("cgui").setExecutor(new CGUICommand());
		
	}
	
}
