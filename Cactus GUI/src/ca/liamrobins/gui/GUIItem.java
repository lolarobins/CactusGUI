package ca.liamrobins.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The base for any items to add to a GUI.
 * <p>
 * To create an item, you may instantiate one by using a constructor to create an item, or for reuse, create a class extending GUIItem (recommended).
 * @author CCMW
 *
 */
public class GUIItem extends ItemStack {
	
	private boolean movable;
	private ArrayList<ItemAction> rightClick = new ArrayList<ItemAction>(), leftClick = new ArrayList<ItemAction>(),
			shiftRightClick = new ArrayList<ItemAction>(), shiftLeftClick = new ArrayList<ItemAction>(), any = new ArrayList<ItemAction>(), 
			q = new ArrayList<ItemAction>(), controlQ = new ArrayList<ItemAction>(), f = new ArrayList<ItemAction>(), middle = new ArrayList<ItemAction>(),
			number = new ArrayList<ItemAction>();
	
	/**
	 * Creates a GUIItem for use with a GUI.
	 * @param material Material to use for the ItemStack.
	 * @param movable Movable by players in GUI.
	 */
	public GUIItem(Material material, boolean movable) {
		this.setType(material);
		this.movable = movable;
		this.setAmount(1);
	}
	
	/**
	 * Creates a GUIItem for use with a GUI.
	 * @param material Material to use for the ItemStack.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 */
	public GUIItem(Material material, boolean movable, String displayName) {
		this.setType(material);
		this.movable = movable;
		this.setDisplayName(displayName);
		this.setAmount(1);
	}
	
	/**
	 * Creates a GUIItem for use with a GUI.
	 * @param material Material to use for the ItemStack.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 * @param lore The lore of the item.
	 */
	public GUIItem(Material material, boolean movable, String displayName, List<String> lore) {
		this.setType(material);
		this.movable = movable;
		this.setDisplayName(displayName);
		this.setLore(lore);
		this.setAmount(1);
	}
	
	/**
	 * Creates a GUIItem for use with a GUI.
	 * @param material Material to use for the ItemStack.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 * @param lore The lore of the item.
	 * @param amount The amount of the item to show.
	 */
	public GUIItem(Material material, boolean movable, String displayName, List<String> lore, int amount) {
		this.setType(material);
		this.movable = movable;
		this.setDisplayName(displayName);
		this.setLore(lore);
		this.setAmount(amount);
	}
	
	/**
	 * Creates a GUIItem for use with a GUI.
	 * @param material Material to use for the ItemStack.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 * @param lore The lore of the item.
	 * @param amount The amount of the item to show.
	 * @param actionRunOnAny Add in an ItemAction for if the player is to do any type of interaction with the item.
	 */
	public GUIItem(Material material, boolean movable, String displayName, List<String> lore, int amount, ItemAction actionRunOnAny) {
		this.setType(material);
		this.movable = movable;
		this.setDisplayName(displayName);
		this.setLore(lore);
		this.setAmount(amount);
		this.any.add(actionRunOnAny);
	}
	
	/**
	 * Checks if the item is movable by players. (Handled by library.)
	 * @return if the item is movable by players in a GUI.
	 */
	public boolean isMovable() {return movable;}
	
	/**
	 * Sets the lore of an item.
	 * @param lore The new lore to set.
	 */
	public void setLore(List<String> lore) {
		ItemMeta newMeta = this.getItemMeta();
		newMeta.setLore(lore);
		this.setItemMeta(newMeta);
	}
	
	/**
	 * Sets the name of an item.
	 * @param displayName The new item name to set.
	 */
	public void setDisplayName(String displayName) {
		ItemMeta newMeta = this.getItemMeta();
		newMeta.setDisplayName(displayName);
		this.setItemMeta(newMeta);
	}
	
	/**
	 * Allows the item to be moved/modified by players accessing the GUI.
	 * @param movable If the player can move the item.
	 */
	public void setMoveable(boolean movable) {this.movable = movable;}
	
	/**
	 * Gets the actions saved to an item.
	 * @param clickType The type of click performed by the player.
	 * @return the actions for that click.
	 */
	public ArrayList<ItemAction> getActions(GUIClickType clickType) {
		switch(clickType) {
		case LEFT_CLICK:
			return leftClick;
		case RIGHT_CLICK:
			return rightClick;
		case SHIFT_LEFT_CLICK:
			return shiftLeftClick;
		case SHIFT_RIGHT_CLICK:
			return shiftRightClick;
		case ANY:
			return any;
		case F:
			return f;
		case MIDDLE_CLICK:
			return middle;
		case Q:
			return q;
		case CONTROL_Q:
			return controlQ;
		default:
			break;
		}
		return null;
	}
	
	/**
	 * Sets the actions for a particular clicktype.
	 * @param clickType The type of click needed to perform the action.
	 * @param action The actions to run upon clicking.
	 */
	public void setActions(GUIClickType clickType, ArrayList<ItemAction> actions) {
		switch(clickType) {
		case LEFT_CLICK:
			leftClick = actions;
			break;
		case RIGHT_CLICK:
			rightClick = actions;
			break;
		case SHIFT_LEFT_CLICK:
			shiftLeftClick = actions;
			break;
		case SHIFT_RIGHT_CLICK:
			shiftRightClick = actions;
			break;
		case ANY:
			any = actions;
			break;
		case F:
			f = actions;
			break;
		case MIDDLE_CLICK:
			middle = actions;
			break;
		case Q:
			q = actions;
			break;
		case CONTROL_Q:
			controlQ = actions;
			break;
		case NUMBER:
			number = actions;
			break;
		default:
			break;
		}
	}
	
	/**
	 * Removes the actions for a particular clicktype.
	 * @param clickType The clicktype to reset.
	 */
	public void removeActions(GUIClickType clickType) {
		switch(clickType) {
		case LEFT_CLICK:
			leftClick = new ArrayList<ItemAction>();
			break;
		case RIGHT_CLICK:
			rightClick = new ArrayList<ItemAction>();
			break;
		case SHIFT_LEFT_CLICK:
			shiftLeftClick = new ArrayList<ItemAction>();
			break;
		case SHIFT_RIGHT_CLICK:
			shiftRightClick = new ArrayList<ItemAction>();
			break;
		case ANY:
			any = new ArrayList<ItemAction>();
			break;
		case F:
			f = new ArrayList<ItemAction>();
			break;
		case MIDDLE_CLICK:
			middle = new ArrayList<ItemAction>();
			break;
		case Q:
			q = new ArrayList<ItemAction>();
			break;
		case CONTROL_Q:
			controlQ = new ArrayList<ItemAction>();
			break;
		case NUMBER:
			number = new ArrayList<ItemAction>();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Adds an action for a particular clicktype.
	 * @param clickType The type of click needed to perform the action.
	 * @param action The action to run upon clicking.
	 */
	public void addAction(GUIClickType clickType, ItemAction action) {
		switch(clickType) {
		case LEFT_CLICK:
			leftClick.add(action);
			break;
		case RIGHT_CLICK:
			rightClick.add(action);
			break;
		case SHIFT_LEFT_CLICK:
			shiftLeftClick.add(action);
			break;
		case SHIFT_RIGHT_CLICK:
			shiftRightClick.add(action);
			break;
		case ANY:
			any.add(action);
			break;
		case F:
			f.add(action);
			break;
		case MIDDLE_CLICK:
			middle.add(action);
			break;
		case Q:
			q.add(action);
			break;
		case CONTROL_Q:
			controlQ.add(action);
			break;
		case NUMBER:
			number.add(action);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Add actions for a particular clicktype.
	 * @param clickType The type of click needed to perform the action.
	 * @param actions The actions to run upon clicking.
	 */
	public void addActions(GUIClickType clickType, ArrayList<ItemAction> actions) {
		switch(clickType) {
		case LEFT_CLICK:
			leftClick.addAll(actions);
			break;
		case RIGHT_CLICK:
			rightClick.addAll(actions);
			break;
		case SHIFT_LEFT_CLICK:
			shiftLeftClick.addAll(actions);
			break;
		case SHIFT_RIGHT_CLICK:
			shiftRightClick.addAll(actions);
			break;
		case ANY:
			any.addAll(actions);
			break;
		case F:
			f.addAll(actions);
			break;
		case MIDDLE_CLICK:
			middle.addAll(actions);
			break;
		case Q:
			q.addAll(actions);
			break;
		case CONTROL_Q:
			controlQ.addAll(actions);
			break;
		case NUMBER:
			number.addAll(actions);
		default:
			break;
		}
	}
	
	/**
	 * Converts each character in provided string to an item corresponding with the characters and items defined in the provided HashMap.
	 * <p>
	 * If character is not found, will default to null. Ensure that string matches, or is less, of the total slots.
	 * @param items HashMap with characters and assigned items.
	 * @param string String with characters in order.
	 * @return a HashMap with the items in their proper positions.
	 */
	public static HashMap<Integer, GUIItem> fromCharacterLayout(HashMap<Character, GUIItem> items, String string){
		HashMap<Integer, GUIItem> toreturn = new HashMap<Integer, GUIItem>();
		char[] characters = string.toCharArray();
		int index = 0;
		for(char c : characters) {
			toreturn.put(index, items.get((Character) c));
			index++;
		}
		return toreturn;
	}
}
