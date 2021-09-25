package ca.cactusmc.gui.type;

import java.util.HashMap;
import org.bukkit.Bukkit;

import ca.cactusmc.gui.BackgroundableGUI;
import ca.cactusmc.gui.GUIItem;

/**
 * For the creation of a chest type GUI.
 * @author CCMW
 *
 */
public class ChestGUI extends BackgroundableGUI {

	int size;
	
	/**
	 * Creates a new ChestGUI.
	 * @param title GUI title
	 * @param rows The amount of rows (1-6)
	 * @throws IllegalArgumentException if rows is not between 1 and 6.
	 */
	public ChestGUI(String title, int rows) {
		
		if(rows<1 || rows>6) {
			throw new IllegalArgumentException("Rows for ChestGUI cannot be less than 1 or greater than 6.");
		}
		
		this.size = rows*9;
		
		setTitle(title);
		
		setInventory(Bukkit.createInventory(null, size, getTitle()));
		setBoundaries();
	}
	
	/**
	 * Creates a new ChestGUI.
	 * @param title GUI title
	 * @param rows The amount of rows (1-6)
	 * @param items HashMap with predefined items.
	 * @throws IllegalArgumentException if rows is not between 1 and 6.
	 */
	public ChestGUI(String title, int rows, HashMap<Integer, GUIItem> items) {
		
		if(rows<1 || rows>6) {
			throw new IllegalArgumentException("Rows for ChestGUI cannot be less than 1 or greater than 6.");
		}
		
		this.size = rows*9;
		
		setTitle(title);
		setItems(items);
		
		setInventory(Bukkit.createInventory(null, size, getTitle()));
		setBoundaries();
	}
	
	/**
	 * Gets the initial provided size of the GUI.
	 * @return the amount of slots.
	 */
	public int getSize() {return size;}

	/**
	 * Refreshes the inventory upon title change.
	 */
	@Override
	public void refresh() {
		setInventory(Bukkit.createInventory(null, size, getTitle()));
		updateItems();
	}
	
}
