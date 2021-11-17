package ca.liamrobins.gui.presets.background;

import java.util.HashMap;

import ca.liamrobins.gui.Background;
import ca.liamrobins.gui.GUIItem;

/**
 * Solid 'color' background of a specific item.
 * @author CCMW
 *
 */
public class Solid extends Background {

	GUIItem item;
	
	/**
	 * Create a solid background of a specified item
	 * @param item
	 */
	public Solid(GUIItem item) {
		this.item = item;
	}
	
	@Override
	protected void draw() {
		HashMap<Integer, GUIItem> items = new HashMap<Integer, GUIItem>();
		
		for(int i = 0; i<getGUI().getUseableSlots(); i++) {
			items.put(i+getGUI().getSlotIncrement(), item);
		}

		setBackgroundItems(items);
	}

}
