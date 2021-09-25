package ca.cactusmc.gui.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import ca.cactusmc.gui.CactusGUI;

/**
 * Not to be used. This is never called.
 * 
 * @see GUIClickEvent
 * 
 * @author CCMW
 */
public abstract class GUIEvent extends Event {
	
	private CactusGUI gui;
	private boolean cancel;
	
	/**
	 * Constructor for use only by events that extend GUIEvent.
	 * @param gui GUI clicked
	 */
	public GUIEvent(CactusGUI gui) {
		this.gui = gui;
	}
	
	/**
	 * Cancels the preset actions on items and/or GUI 
	 * @param cancel Whether or not the actions will be cancelled.
	 */
	public void cancelActions(boolean cancel) {
		this.cancel = cancel;
	}
	
	/**
	 * Checks if the preset actions have been cancelled
	 * @return cancelled.
	 */
	public boolean actionsCancelled() {
		return cancel;
	}
	
	/**
	 * Gets the GUI from the event.
	 * @return respective GUI.
	 */
	public CactusGUI getGUI() {
		return gui;
	}
	
	private static final HandlerList handlers = new HandlerList();
	/**
	 * Get the handlers for the event.
	 */
	@Override
	public HandlerList getHandlers() {return handlers;}
	/**
	 * Returns handler list.
	 */
	public static HandlerList getHandlerList() {return handlers;}
	
	
}
