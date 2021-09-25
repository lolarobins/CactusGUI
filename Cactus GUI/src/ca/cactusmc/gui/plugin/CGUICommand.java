package ca.cactusmc.gui.plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.GUIItem;
import ca.cactusmc.gui.ItemAction;
import ca.cactusmc.gui.presets.background.RainbowRoad;
import ca.cactusmc.gui.presets.item.ConfirmButton;
import ca.cactusmc.gui.type.AnvilTextGUI;
import ca.cactusmc.gui.type.ChestGUI;

/**
 * Command/GUI test class. Not for use in plugin.
 * @author CCMW
 *
 */
public class CGUICommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(!(arg0 instanceof Player)) return true;
		if(arg3.length == 0) return true;
		
		Player p = (Player) arg0;
		
		switch(arg3[0]) {
		
		case "rainbow":
			
			ChestGUI rainbow = new ChestGUI("Rainbow Road Animation", 6);
			rainbow.setBackground(new RainbowRoad(1, true));
			rainbow.showTo(p);
			break;
			
		case "anvil":
			
			AnvilTextGUI anvil = new AnvilTextGUI("Anvil Test", null, new ItemAction() {
				@Override
				public void run(Player player, CactusGUI gui, GUIItem item) {
					if(!(item instanceof ConfirmButton)) return;
					Bukkit.dispatchCommand(p, ((AnvilTextGUI) gui).getEnteredText());
				}	
			});
			anvil.showTo(p);
			break;
			
		}
		return true;
	}
	
}
