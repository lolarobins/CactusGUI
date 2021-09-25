package ca.cactusmc.gui.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.inventory.InventoryClickEvent;
import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.GUIItem;


/**
 * Called when a player clicks an item in a GUI.
 * <p>
 * Note: Actions attributed to a GUIItem will still run.
 * @author CCMW
 */

public class GUIClickEvent extends GUIEvent implements Cancellable {

	private InventoryClickEvent e;
	private GUIItem item;
	
	/**
	 * Constructor for when the method is invoked by CactusGUI.
	 * @param e Initial event
	 * @param gui GUI clicked
	 * @param item Item clicked
	 */
	public GUIClickEvent(InventoryClickEvent e, CactusGUI gui, GUIItem item) {
		super(gui);
		this.e = e;
		this.item = item;
	}
	
	/**
	 * Gets the item that was clicked.
	 * @return the clicked GUIItem.
	 */
	public GUIItem getItem() {
		return item;
	}
	
	/**
	 * The event that was expanded upon.
	 * @return the initial InventoryClickEvent that was called.
	 */
	public InventoryClickEvent getInitialEvent() {
		return e;
	}

	/**
	 * Returns the initial event's .isCancelled() boolean.
	 * @return the initial event {@link InventoryClickEvent#isCancelled()}
	 */
	@Override
	public boolean isCancelled() {
		return e.isCancelled();
	}
	
	/**
	 * Cancells the initial event.
	 * @param cancelled Performs {@link InventoryClickEvent#setCancelled(boolean)} on the initial InventoryClickEvent.
	 */
	@Override
	public void setCancelled(boolean cancelled) {
		e.setCancelled(cancelled);
	}
	
}
