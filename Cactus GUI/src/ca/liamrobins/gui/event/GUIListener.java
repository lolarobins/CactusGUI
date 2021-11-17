package ca.liamrobins.gui.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

import ca.liamrobins.gui.AnimatedBackground;
import ca.liamrobins.gui.BackgroundableGUI;
import ca.liamrobins.gui.CactusGUI;
import ca.liamrobins.gui.GUIAction;
import ca.liamrobins.gui.GUIActionType;
import ca.liamrobins.gui.GUIItem;


/**
 * Library's listener to reroute events to custom GUI ones.
 * <p>
 * No implementation for developers.
 * @author CCMW
 */
public class GUIListener implements Listener {
	
	@EventHandler
	public void GUIEvent(InventoryClickEvent e) {
		
		if(e.getInventory() == null) return;
		if(e.getInventory().getType() == InventoryType.PLAYER) return;
		
		Player p = Bukkit.getPlayer(e.getWhoClicked().getName());
		
		if(CactusGUI.get(p) != null && CactusGUI.get(p).getInventory().getType() == e.getInventory().getType()) {
			
			CactusGUI gui = CactusGUI.get(p);
			
			if(!gui.isModifiable()) e.setCancelled(true);
			if(!(gui.getItem(e.getSlot()) instanceof GUIItem)) return;
			
			GUIItem item = gui.getItem(e.getSlot());
			
			GUIClickEvent call = new GUIClickEvent(e, gui, item);
			Bukkit.getServer().getPluginManager().callEvent(call);
			
			if(!item.isMovable()) e.setCancelled(true);
			
			if(call.actionsCancelled()) return;
			
			
			
		}
		
	}
	
	@EventHandler
	public void GUIEvent(InventoryOpenEvent e) {
		
		if(e.getInventory() == null) return;
		if(e.getInventory().getType() == InventoryType.PLAYER) return;
		
		Player p = Bukkit.getPlayer(e.getPlayer().getName());
		
		if(CactusGUI.get(p) != null && CactusGUI.get(p).getInventory().getType() == e.getInventory().getType()) {
			for(GUIAction action : CactusGUI.get(p).getActions(GUIActionType.OPEN)) {action.run(p, CactusGUI.get(p));}
		}
	}
	
	@EventHandler
	public void GUIEvent(InventoryCloseEvent e) {
		
		if(e.getInventory() == null) return;
		if(e.getInventory().getType() == InventoryType.PLAYER) return;
		
		Player p = Bukkit.getPlayer(e.getPlayer().getName());
		
		if(CactusGUI.get(p) != null && CactusGUI.get(p).getInventory().getType() == e.getInventory().getType()) {
			for(GUIAction action : CactusGUI.get(p).getActions(GUIActionType.CLOSE)) {action.run(p, CactusGUI.get(p));}
			if(CactusGUI.get(p) instanceof BackgroundableGUI && ((BackgroundableGUI)CactusGUI.get(p)).getBackground() instanceof AnimatedBackground) 
				((AnimatedBackground) ((BackgroundableGUI) CactusGUI.get(p)).getBackground()).stop();
			CactusGUI.removeFromCache(p);
		}
	}
	
}
