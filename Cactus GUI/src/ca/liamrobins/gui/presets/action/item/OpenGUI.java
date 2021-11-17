package ca.liamrobins.gui.presets.action.item;

import org.bukkit.entity.Player;

import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

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
