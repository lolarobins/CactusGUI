package ca.cactusmc.gui;

import java.util.HashMap;

/**
 * The base for all custom backgrounds. Allows background classes to get the GUI for dimensions, etc.
 * @author CCMW
 *
 */
public abstract class Background {
	
	private BackgroundableGUI hookedGUI;
	
	/**
	 * Gets the GUI the background is targeted to.
	 * @return the hooked GUI.
	 */
	public BackgroundableGUI getGUI() {
		return hookedGUI;
	}
	
	void hookGUI(BackgroundableGUI gui) {
		hookedGUI = gui;
		draw();
	}
	
	/**
	 * For developers to set a HashMap of background items.
	 * @param items
	 */
	protected void setBackgroundItems(HashMap<Integer, GUIItem> items) {hookedGUI.setBackgroundItems(items);}
	
	/**
	 * Draws the background.
	 */
	protected abstract void draw();
}
