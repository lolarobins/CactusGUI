package ca.cactusmc.gui.presets.action.item;

import org.bukkit.entity.Player;

import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.ItemAction;
import ca.cactusmc.gui.GUIItem;

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
