package ca.cactusmc.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Parent class to the supported GUIs provided by CactusGUI.
 * <p>
 * To create a GUI, instantiate a new GUI of any type from the list below:
 * @see ca.cactusmc.gui.type.ChestGUI
 * @see ca.cactusmc.gui.type.DispenserGUI
 * @see ca.cactusmc.gui.type.HopperGUI
 * @see ca.cactusmc.gui.type.AnvilTextGUI
 * @author CCMW
 */
public abstract class CactusGUI {
	
	private static final String VERSION = "1.0";
	
	/**
	 * Gets the version of CactusGUI
	 * @return version of CactusGUI
	 */
	public static final String getVersion() {
		return VERSION;
	}
	
	private static HashMap<UUID, CactusGUI> cache = new HashMap<UUID, CactusGUI>();
	
	/**
	 * The cache stores the open GUI for players, allowing CactusGUI to work properly for the given GUI upon any events.
	 * <p>
	 * It is recommended that developers use {@link #show()} along with {@link #setTargetPlayer(Player)} to open a GUI, or {@link #showTo(Player)}.
	 * <p>
	 * If you opt to open the inventory yourself, please call this method before you open the inventory.
	 * @param player Player that opened the GUI.
	 * @param gui The instance of the opened GUI.
	 */
	public static void addToCache(Player player, CactusGUI gui) {
		cache.put(player.getUniqueId(), gui);
	}
	
	/**
	 * Automatically called upon with an InventoryCloseEvent to save memory.
	 * @param player Player that closed the GUI.
	 */
	public static void removeFromCache(Player player) {
		cache.remove(player.getUniqueId());
	}
	
	/**
	 * Gets the open GUI for a specified player.
	 * @param player Player with cached GUI.
	 * @return the GUI the player has cached. Null if none is open.
	 */
	@Nullable
	public static CactusGUI get(Player player) {
		if(player == null) {
			throw new NullPointerException("Specified player cannot be null.");
		}
		return cache.get(player.getUniqueId());
	}
	
	protected Inventory inventory;
	protected String title;
	protected HashMap<Integer, GUIItem> items = new HashMap<Integer, GUIItem>();
	protected boolean modifiable;
	protected Player player;
	protected ArrayList<GUIAction> close = new ArrayList<GUIAction>(), open = new ArrayList<GUIAction>();
	
	/**
	 * Gets the targeted player. Must be set.
	 * @return the player the GUI is targeted to. Null if none specified.
	 */
	@Nullable
	public Player getTargetPlayer() {return player;}
	
	/**
	 * Gets the title of the inventory.
	 * @return the title of the inventory.
	 */
	@Nonnull
	public String getTitle() {return title;}
	
	/**
	 * Gets the inventory created to host the GUI.
	 * @return the inventory itself.
	 */
	@Nonnull
	public Inventory getInventory() {return inventory;}
	
	/**
	 * Gets the items in the GUI.
	 * @return a HashMap storing the items and their slots.
	 */
	@Nonnull
	public HashMap<Integer, GUIItem> getItems() {return items;}
	
	/**
	 * Gets an item at a particular slot.
	 * @param slot The slot to pull the item from.
 	 * @return the item at the particular slot. Null if no item exists.
	 */
	@Nullable
	public GUIItem getItem(int slot) {
		if(!items.containsKey(slot)) return null;
		return items.get(slot);
	}
	
	/**
	 * Modifiable if players are allowed to move items.
	 * @return modifiable.
	 */
	@Nonnull
	public boolean isModifiable() {return modifiable;}
	
	protected void setInventory(Inventory inventory) {this.inventory = inventory; updateItems();}
	protected void setTitle(String title) {this.title = title;}
	
	/**
	 * Sets the player the GUI is targeted towards. Required for {@link CactusGUI#showTo()} to work.
	 * @param player Player to target.
	 */
	public void setTargetPlayer(Player player) {this.player = player;}
	
	/**
	 * Removes all items and replaces them with new HashMap.
	 * @param items New items for GUI.
	 */
	public void setItems(HashMap<Integer, GUIItem> items) {this.items = items; updateItems();}
	
	/**
	 * Adds items to GUI. Will override if slot is occupied.
	 * @param items New items for GUI.
	 */
	public void addItems(HashMap<Integer, GUIItem> items) {this.items.putAll(items); updateItems();}
	
	/**
	 * Sets the item at specified slot.
	 * @param slot Slot to set.
	 * @param item Item to set.
	 */
	public void setItem(int slot, GUIItem item) {items.put(slot, item); updateItems();}
	
	/**
	 * Allows/prevents players from modifying the contents of the GUI.
	 * @param modifiable True if players may modify contents.
	 */
	public void setModifiable(boolean modifiable) {this.modifiable = modifiable;}
	
	/**
	 * Each type of GUI will have a refresh method to safely refresh itself with new data.
	 */
	public abstract void refresh();
	
	/**
	 * Updates the ItemStacks of the inventory to match those defined in the CactusGUI. Done automatically by any change of item.
	 */
	public void updateItems() {
		if(inventory == null) return;
		inventory.clear();
		for(int i : items.keySet()) {
			inventory.setItem(i, items.get(i));
		}
	}
	
	/**
	 * Shows to a player and caches.
	 * @param player Player to show GUI to.
	 */
	public void showTo(Player player) {
		addToCache(player, this);
		player.openInventory(inventory);
	}
	
	/**
	 * Shows GUI to the set target player.
	 * Target player must be set.
	 * @throws NullPointerException if no target player is set.
	 */
	public void show() {
		if(player == null) {
			throw new NullPointerException("#setTargetPlayer(player) needs to be specified before using #show()");
		}
		addToCache(player, this);
		player.openInventory(inventory);
	}
	
	/**
	 * Gets the actions saved to a GUI.
	 * @param actionType The type of action performed by the player.
	 * @return the actions to perform.
	 */
	public ArrayList<GUIAction> getActions(GUIActionType actionType) {
		switch(actionType) {
		case CLOSE:
			return close;
		case OPEN:
			return open;
		}
		return null;
	}
	
	/**
	 * Sets the actions for a particular action type.
	 * @param actionType The type of GUI action needed to perform the actions.
	 * @param action The actions to run.
	 */
	public void setActions(GUIActionType actionType, ArrayList<GUIAction> actions) {
		switch(actionType) {
		case CLOSE:
			close = actions;
		case OPEN:
			open = actions;
		}
	}
	
	/**
	 * Removes the actions for a particular action type.
	 * @param actionType The action type to reset.
	 */
	public void removeActions(GUIActionType actionType) {
		switch(actionType) {
		case CLOSE:
			close = new ArrayList<GUIAction>();
			break;
		case OPEN:
			open = new ArrayList<GUIAction>();
			break;
		}
	}
	
	/**
	 * Adds an action for a particular action type.
	 * @param clickType The type of GUI action needed to perform the action.
	 * @param action The action to run.
	 */
	public void addAction(GUIActionType actionType, GUIAction action) {
		switch(actionType) {
		case CLOSE:
			close.add(action);
			break;
		case OPEN:
			close.add(action);
			break;
		}
	}
	
	/**
	 * Add actions for a particular action type.
	 * @param actionType The type of GUI action needed to perform the action.
	 * @param actions The actions to run.
	 */
	public void addActions(GUIActionType actionType, ArrayList<GUIAction> actions) {
		switch(actionType) {
		case CLOSE:
			close.addAll(actions);
			break;
		case OPEN:
			close.addAll(actions);
		}
	}
}
