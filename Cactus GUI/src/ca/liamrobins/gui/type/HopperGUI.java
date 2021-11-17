package ca.liamrobins.gui.type;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;

import ca.liamrobins.gui.BackgroundableGUI;
import ca.liamrobins.gui.GUIItem;

/**
 * For the creation of a hopper type GUI. Useful if you want a 1x5 grid GUI.
 * @author CCMW
 *
 */
public class HopperGUI extends BackgroundableGUI {
	
	
	/**
	 * Creates a new HopperGUI.
	 * @param title GUI title.
	 */
	public HopperGUI(String title) {
		
		setTitle(title);
		
		setInventory(Bukkit.createInventory(null, InventoryType.HOPPER, getTitle()));
		setBoundaries();
		
	}
	
	/**
	 * Creates a new HopperGUI.
	 * @param title GUI title.
	 * @param items HashMap with predefined items.
	 */
	public HopperGUI(String title, HashMap<Integer, GUIItem> items) {
		
		setItems(items);
		setTitle(title);
		
		setInventory(Bukkit.createInventory(null, InventoryType.HOPPER, getTitle()));
		setBoundaries();
		
	}
	
	/**
	 * Refreshes the inventory upon title change.
	 */
	@Override
	public void refresh() {
		
		setInventory(Bukkit.createInventory(null, InventoryType.HOPPER, getTitle()));
		updateItems();
		
	}
	
	
}
