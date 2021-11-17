package ca.liamrobins.gui.presets.action.item;

import org.bukkit.entity.Player;

import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

/**
 * Closes the opened inventory.
 * @author CCMW
 */
public class CloseGUI implements ItemAction {

	@Override
	public void run(Player player, CactusGUI gui, GUIItem item) {
		player.closeInventory();
	}

}
