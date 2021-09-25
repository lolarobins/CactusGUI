package ca.cactusmc.gui.presets.item;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.meta.SkullMeta;

import ca.cactusmc.gui.GUIItem;
import ca.cactusmc.gui.ItemAction;

/**
 * A preset playerhead GUIItem.
 * @author CCMW
 *
 */
public class PlayerHead extends GUIItem {

	OfflinePlayer owner;
	
	/**
	 * Set the owner of a PlayerHead
	 * @param owner OfflinePlayer to use the head of.
	 */
	public void setOwner(OfflinePlayer owner) {
		this.owner = owner;
		SkullMeta sm = (SkullMeta) getItemMeta();
		sm.setOwningPlayer(owner);
	}
	
	/**
	 * Gets the owner of the playerhead.
	 * @return the OfflinePlayer that owns the head.
	 */
	public OfflinePlayer getOwner() {return this.owner;}
	
	/**
	 * Creates a playerhead GUIItem.
	 * @param owner OfflinePlayer to use the head of.
	 * @param movable Movable by players in GUI.
	 */
	public PlayerHead(OfflinePlayer owner, boolean movable) {
		super(Material.PLAYER_HEAD, movable);
		setOwner(owner);
	}
	
	/**
	 * Creates a playerhead GUIItem.
	 * @param owner OfflinePlayer to use the head of.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 */
	public PlayerHead(OfflinePlayer owner, boolean movable, String displayName) {
		super(Material.PLAYER_HEAD, movable, displayName);
		setOwner(owner);
	}
	
	/**
	 * Creates a playerhead GUIItem.
	 * @param owner OfflinePlayer to use the head of.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 * @param lore The lore of the item.
	 */
	public PlayerHead(OfflinePlayer owner, boolean movable, String displayName, List<String> lore) {
		super(Material.PLAYER_HEAD, movable, displayName, lore);
		setOwner(owner);
	}
	
	/**
	 * Creates a playerhead GUIItem.
	 * @param owner OfflinePlayer to use the head of.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 * @param lore The lore of the item.
	 * @param amount The amount of the item to show.
	 */
	public PlayerHead(OfflinePlayer owner, boolean movable, String displayName, List<String> lore, int amount) {
		super(Material.PLAYER_HEAD, movable, displayName, lore, amount);
		setOwner(owner);
	}
	
	/**
	 * Creates a playerhead GUIItem.
	 * @param owner OfflinePlayer to use the head of.
	 * @param movable Movable by players in GUI.
	 * @param displayName The name of the item.
	 * @param lore The lore of the item.
	 * @param amount The amount of the item to show.
	 * @param actionRunOnAny Add in a GUIAction for if the player is to do any type of interaction with the item.
	 */
	public PlayerHead(OfflinePlayer owner, boolean movable, String displayName, List<String> lore, int amount, ItemAction actionRunOnAny) {
		super(Material.PLAYER_HEAD, movable, displayName, lore, amount, actionRunOnAny);
		setOwner(owner);
	}
}
