package ca.cactusmc.gui;

import java.util.HashMap;

/**
 * Draw preset patterns on a GUI with this tool.
 * @author CCMW
 *
 */
public class Patterner {
	
	BackgroundableGUI gui;
	
	Patterner(BackgroundableGUI gui){
		this.gui = gui;
	}
	
	public void DrawRectangle(GUIItem item, int x1, int y1, int x2, int y2) {
		
		if(x1 < 0 || y1 < 0 || x2 >= gui.getWidth() || y2 >= gui.getHeight()) {
			throw new IllegalArgumentException("Coordinate not within bounds of inventory.");
		}
		
		HashMap<Integer, GUIItem> items = new HashMap<Integer, GUIItem>();
		
		for(int x = x1; x < x2+1; x++) {
			for(int y = y1; y < y2+1; y++) {
				items.put(gui.getSlot(x, y), item);
			}
		}
		
		gui.addItems(items);
	}
	
}
