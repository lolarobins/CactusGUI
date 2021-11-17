package ca.liamrobins.gui.presets.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIClickType;
import ca.liamrobins.gui.GUIItem;
import ca.liamrobins.gui.ItemAction;

/**
 * A preset GUIItem that closes the GUI.
 * @author CCMW
 */
public class CloseButton extends GUIItem {

	
	/**
	 * The button itself. Red wool, non-movable, red and bolded title of "Close".
	 */
	public CloseButton() {
		super(Material.RED_CONCRETE, false, ChatColor.RED +""+ ChatColor.BOLD + "Close");
		
		this.setAmount(1);
		
		this.addAction(GUIClickType.ANY, new ItemAction() {
			@Override
			public void run(Player player, CactusGUI gui, GUIItem item) {
				player.closeInventory();
			}
		});
	}
	
}
