package ca.cactusmc.gui.presets.background;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import ca.cactusmc.gui.AnimatedBackground;
import ca.cactusmc.gui.GUIItem;

/**
 * An animated background that places random glass panes.
 * @author CCMW
 *
 */
public class PaneRandomizer extends AnimatedBackground {

	private int random(int max, int min){
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
	
	protected PaneRandomizerOption option;
	
	/**
	 * Instantiates a PaneRandomizer with all type of glass panes.
	 * @param ticksbetween The delay in ticks between each animation frame.
	 */
	public PaneRandomizer(int ticksbetween) {
		option = PaneRandomizerOption.ANY;
		setTickSpeed(ticksbetween);
	}
	
	/**
	 * Instantiates a PaneRandomizer.
	 * @param ticksbetween The delay in ticks between each animation frame.
	 * @param option Selects the style.
	 */
	public PaneRandomizer(int ticksbetween, PaneRandomizerOption option) {
		this.option = option;
		setTickSpeed(ticksbetween);
	}
	
	@Override
	protected void draw() {
		HashMap<Integer, GUIItem> items = new HashMap<Integer, GUIItem>();
		for(int i = 0; i < getGUI().getUseableSlots(); i++) {
			switch(option) {
			case ANY:
				int random1 = random(-1, 16);
				switch(random1) {
				case 0: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.BLACK_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 1: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.WHITE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 2: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.GRAY_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 3: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 4: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.BROWN_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 5: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.MAGENTA_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 6: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.RED_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 7: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.PINK_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 8: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.BLUE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 9: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 10: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.CYAN_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 11: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.GREEN_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 12: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.YELLOW_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 13: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.LIME_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 14: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.PURPLE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 15: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.ORANGE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				}
				break;
			case LIGHT:
				int random2 = random(-1, 6);
				switch(random2) {
				case 0: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.YELLOW_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 1: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.LIME_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 2: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.PINK_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 3: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 4: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.WHITE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 5: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.MAGENTA_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				}
				break;
			case DARK:
				int random3 = random(-1, 6);
				switch(random3) {
				case 0: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.BROWN_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 1: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.RED_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 2: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.CYAN_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 3: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.GREEN_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 4: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.ORANGE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 5: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.PURPLE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				}
				break;
			case MONOTONE:
				int random4 = random(-1, 4);
				switch(random4) {
				case 0: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.BLACK_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 1: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.WHITE_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 2: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.GRAY_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				case 3: items.put(i+getGUI().getSlotIncrement(), new GUIItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, false, ChatColor.RESET+"")); break;
				}
				break;
			}
		}
		
		setBackgroundItems(items);
		
		doNextUpdate();	
	}

	
	
}
