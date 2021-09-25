package ca.cactusmc.gui.type;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;

import ca.cactusmc.gui.BackgroundableGUI;
import ca.cactusmc.gui.GUIItem;

/**
 * For the creation of a dispenser type GUI. Useful if you want a 3x3 grid GUI.
 * @author CCMW
 *
 */
public class DispenserGUI extends BackgroundableGUI {

	/**
	 * Creates a new DispenserGUI.
	 * @param title GUI title.
	 */
	public DispenserGUI(String title) {
		
		setTitle(title);
		
		setInventory(Bukkit.createInventory(null, InventoryType.DISPENSER, getTitle()));
		setBoundaries();
	}
	
	/**
	 * Creates a new DispenserGUI.
	 * @param title GUI title.
	 * @param items HashMap with predefined items.
	 */
	public DispenserGUI(String title, HashMap<Integer, GUIItem> items) {
		
		setTitle(title);
		setItems(items);
		
		setInventory(Bukkit.createInventory(null, InventoryType.DISPENSER, getTitle()));
		setBoundaries();
	}

	/**
	 * Refreshes the inventory upon title change.
	 */
	@Override
	public void refresh() {
		setInventory(Bukkit.createInventory(null, InventoryType.DISPENSER, getTitle()));
		updateItems();
	}
	
}
