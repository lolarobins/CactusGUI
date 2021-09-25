package ca.cactusmc.gui.presets.action.item;

import org.bukkit.entity.Player;

import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.ItemAction;
import ca.cactusmc.gui.GUIItem;

/**
 * Opens a specified GUI.
 * @author CCMW
 */
public class OpenGUI implements ItemAction {

	CactusGUI newGUI;
	
	/**
	 * Opens a GUI.
	 * @param newGUI The GUI to open.
	 */
	public OpenGUI(CactusGUI newGUI) {
		this.newGUI = newGUI;
	}
	
	@Override
	public void run(Player player, CactusGUI gui, GUIItem item) {
		newGUI.showTo(player);
	}

}
