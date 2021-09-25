package ca.cactusmc.gui.presets.background;

import java.util.HashMap;

import ca.cactusmc.gui.Background;
import ca.cactusmc.gui.BackgroundableGUI;
import ca.cactusmc.gui.GUIItem;

/**
 * Checkerboard background of two defined items.
 * @author CCMW
 *
 */
public class Checker extends Background {
	
	private HashMap<Character, GUIItem> map = new HashMap<Character, GUIItem>();
	
	/**
	 * Creates the checkerboard background.
	 * @param item1 First item to use.
	 * @param item2 Second item to use.
	 */
	public Checker(GUIItem item1, GUIItem item2) {
		map.put('a', item1);
		map.put('b', item2);
	}
	
	@Override
	protected void draw() {
		
		BackgroundableGUI gui = this.getGUI();
		
		switch(gui.getInventory().getType()) {
		
		case CHEST:
			
			String string = "";
			String add = "ababababa";
			String add2 = "babababab";
			
			for(int i=0; i<(getGUI().getUseableSlots()/9); i++) {
				if(i == 0 || i%2 == 0) {
					string=string+add;
				}else {
					string=string+add2;
				}
			}
			setBackgroundItems(GUIItem.fromCharacterLayout(map, string));
			break;
			
		case DISPENSER:
			setBackgroundItems(GUIItem.fromCharacterLayout(map, "ababababa"));
			break;
			
		case HOPPER:
			setBackgroundItems(GUIItem.fromCharacterLayout(map, "ababa"));
			break;
			
		case WORKBENCH:
			setBackgroundItems(GUIItem.fromCharacterLayout(map, "_ababababa"));
			break;
			
		default:
			break;
		}
	}
	
}
