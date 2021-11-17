package ca.liamrobins.gui.presets.item;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import ca.liamrobins.gui.GUIClickType;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

/**
 * A confirm button, intended for text anvils but could be used for other things.
 * @author CCMW
 *
 */
public class ConfirmButton extends GUIItem {

	/**
	 * Instantiate a new ConfirmButton
	 * @param lore The lore of the button.
	 * @param action The action to run on click, could have some type of confirmation.
	 */
	public ConfirmButton(List<String> lore, ItemAction action) {
		super(Material.LIME_CONCRETE, false, ChatColor.GREEN +""+ ChatColor.BOLD + "Confirm", lore);
		
		this.addAction(GUIClickType.ANY, action);
		
	}

}
