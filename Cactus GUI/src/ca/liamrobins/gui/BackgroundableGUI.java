package ca.liamrobins.gui;

import java.util.HashMap;
import java.util.HashSet;

import javax.annotation.Nonnull;

import org.bukkit.event.inventory.InventoryType;

/**
 * A GUI with a grid that can be painted upon.
 * @author CCMW
 *
 */
public abstract class BackgroundableGUI extends CactusGUI {
	
	protected int width, height, increment;
	protected Background guibackground;
	protected HashMap <Integer, GUIItem> background = new HashMap<Integer, GUIItem>();
	protected void setBackgroundItems(HashMap<Integer, GUIItem> items) {this.background = items; updateItems();}
	
	/**
	 * Gets the patterner for the inventory.
	 * @return a patterner instance.
	 */
	public Patterner getPatterner() {
		return new Patterner(this);
	}
	
	/**
	 * Gets the amount of slots that can be used for a background.
	 * @return slots in inventory.
	 */
	public int getUseableSlots() {
		if(getInventory().getType() == InventoryType.WORKBENCH) return 9;
		return getInventory().getSize();
	}
	
	/**
	 * Gets the width of the usable inventory space.
	 * @return width of the inventory.
	 */
	public int getWidth() {return this.width;}
	/**
	 * Gets the height of the usable inventory space.
	 * @return height of the inventory.
	 */
	public int getHeight() {return this.height;}
	/**
	 * Gets an increment amount for inventories which grids do not start at slot 0.
	 * <p>
	 * Only use currently: Workbench GUI.
	 * @return increment of the inventory.
	 */
	public int getSlotIncrement() {return this.increment;}
	
	/**
	 * Gets an item at a particular slot. If none exists, it will attempt to pull one from the background.
	 * @param slot The slot to pull the item from.
 	 * @return the item at the particular slot. Null if no item exists.
	 */
	@Override
	public GUIItem getItem(int slot) {
		if(!items.containsKey(slot) && !background.containsKey(slot)) return null;
		if(!items.containsKey(slot)) return background.get(slot);
		return items.get(slot);
	}
	
	/**
	 * Gets the slot at a coordinate according to inventory type.
	 * @param x The x coordinate (left-right) starting at 0.
	 * @param y The y coordinate (top-down) starting at 0.
	 * @return the slot, -1 if out of bounds.
	 */
	public int getSlot(int x, int y) {
		if((y >= height) || (x >= width)) return -1;
		return y*width+x+increment;
	}
	
	/**
	 * Gets a set of slots in specified row if they exist.
	 * @param y The Y value of the row.
	 * @return a set with the # the slots are at.
	 */
	public HashSet<Integer> getSlotsInRow(int y) {
		HashSet<Integer> toreturn = new HashSet<Integer>();
		for(int i=0; i>=width; i++) {
			if(getSlot(i,y) != -1)toreturn.add(getSlot(i,y));
		}
		return toreturn;
	}
	
	/**
	 * Gets a set of slots in specified column if they exist.
	 * @param y The X value of the column.
	 * @return a set with the # the slots are at.
	 */
	public HashSet<Integer> getSlotsInColumn(int x) {
		HashSet<Integer> toreturn = new HashSet<Integer>();
		for(int i=0; i>=height; i++) {
			if(getSlot(x,i) != -1) toreturn.add(getSlot(x,i));
		}
		return toreturn;
	}
	
	/**
	 * Updates the width and height for functions such as getSlot(x, y).
	 */
	public void setBoundaries() {
		switch(getInventory().getType()) {
		case CHEST:
			width = 9 ;
			height = getInventory().getSize() / 9;
			break;
		case DISPENSER:
			width = 3;
			height = 3;
			break;
		case HOPPER:
			width = 5;
			height = 1;
			break;
		case WORKBENCH:
			width = 3;
			height = 3;
			break;
		default:
			break;
		}
	}
	
	/**
	 * Updates the ItemStacks of the inventory to match those defined in the CactusGUI. Done automatically by any change of item.
	 */
	@Override
	public void updateItems() {
		if(inventory == null) return;
		HashMap<Integer, GUIItem> tmp = new HashMap<Integer, GUIItem>();
		tmp.putAll(background);
		tmp.putAll(items);
		inventory.clear();
		for(int i : tmp.keySet()) {
			inventory.setItem(i, tmp.get(i));
		}
	}
	
	/**
	 * Sets the background (static or animated) of the GUI.
	 * @param background Background to set.
	 */
	public void setBackground(Background background) {this.guibackground = background; background.hookGUI(this);}
	
	/**
	 * Gets the background of the GUI. Either an animation or static background.
	 * @return the Background linked.
	 */
	@Nonnull
	public Background getBackground() {return guibackground;}
}
