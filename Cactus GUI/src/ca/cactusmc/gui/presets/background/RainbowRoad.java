package ca.cactusmc.gui.presets.background;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import ca.cactusmc.gui.AnimatedBackground;
import ca.cactusmc.gui.GUIItem;

/**
 * A moving Rainbow background.
 * @author CCMW
 *
 */
public class RainbowRoad extends AnimatedBackground {

	private int random(int max, int min){
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
	
	public RainbowRoad(int ticksbetween, boolean forward) {
		setTickSpeed(ticksbetween);
		this.forward = forward;
		this.index = random(-1, 7);
	}
	
	private boolean forward;
	private int index;
	
	private GUIItem getItem(int col){
		ArrayList<GUIItem> toreturn = new ArrayList<GUIItem>();
		
		int newcol = col;
		if(col > 6 || col < -6) {
			newcol = col%7;
		}
		
		toreturn.add(new GUIItem(Material.RED_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		toreturn.add(new GUIItem(Material.ORANGE_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		toreturn.add(new GUIItem(Material.YELLOW_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		toreturn.add(new GUIItem(Material.LIME_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		toreturn.add(new GUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		toreturn.add(new GUIItem(Material.PURPLE_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		toreturn.add(new GUIItem(Material.PINK_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		
		Collections.rotate(toreturn, -index);
		return toreturn.get(newcol);
	}
	
	@Override
	protected void draw() {
		HashMap<Integer, GUIItem> items = new HashMap<Integer, GUIItem>();
		
		for(int col = 0; col < getGUI().getWidth(); col++) {
			for(int row = 0; row < getGUI().getHeight(); row++) {
				items.put(getGUI().getSlot(col, row), getItem(col));
			}
		}
		
		if(!forward) {
			index++;
		}else {
			index--;
		}
		
		if(index > 6 || index < -6) {
			index = index%7;
		}
		
		setBackgroundItems(items);
		doNextUpdate();
	}
	
}
