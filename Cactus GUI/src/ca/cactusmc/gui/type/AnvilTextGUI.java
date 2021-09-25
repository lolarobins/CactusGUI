package ca.cactusmc.gui.type;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;

import ca.cactusmc.gui.CactusGUI;
import ca.cactusmc.gui.GUIItem;
import ca.cactusmc.gui.ItemAction;
import ca.cactusmc.gui.anvil.version.VersionMatcher;
import ca.cactusmc.gui.anvil.version.VersionWrapper;
import ca.cactusmc.gui.presets.item.ConfirmButton;

public class AnvilTextGUI extends CactusGUI {

	private static VersionWrapper WRAPPER = new VersionMatcher().match();
	private int containerId;
	
	/**
	 * Creates a new AnvilTextGUI. Recommended that you use {@link #AnvilTextGUI(String, String, ItemAction)}.
	 * @param title GUI title.
	 */
	public AnvilTextGUI(String title) {
		setTitle(title);
	}
	
	/**
	 * Creates a new AnvilTextGUI.
	 * <p>
	 * Preset confirm button is added. The lore and action on confirm are definable.
	 * @param title GUI title.
	 * @param confirmLore Lore of confirm button.
	 * @param confirmAction Action when confirm button is clicked.
	 */
	public AnvilTextGUI(String title, List<String> confirmLore, ItemAction confirmAction) {
		
		setTitle(title);
		
		setItem(0, new GUIItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE, false, ChatColor.RESET+""));
		setItem(1, new ConfirmButton(confirmLore, confirmAction));
		
	}
	
	@Override
	public void show() {
		if(player == null) {
			throw new NullPointerException("#setTargetPlayer(player) needs to be specified before using #show()");
		}
		
		showTo(getTargetPlayer());
	}
	
	@Override
	public void showTo(Player player) {
		
		WRAPPER.setActiveContainerDefault(player);
		
		final Object container = WRAPPER.newContainerAnvil(player, getTitle());
		setInventory(WRAPPER.toBukkitInventory(container));
		
		updateItems();
		
		containerId = WRAPPER.getNextContainerId(player, container);
        WRAPPER.sendPacketOpenWindow(player, containerId, getTitle());
        WRAPPER.setActiveContainer(player, container);
        WRAPPER.setActiveContainerId(container, containerId);
        WRAPPER.addActiveContainerSlotListener(container, player);
		
		addToCache(player, this);
	}
	
	/**
	 * Gets the text entered in anvil.
	 * @return text entered.
	 */
	public String getEnteredText() {
		return ((AnvilInventory) this.getInventory()).getRenameText();
	}
	
	@Override
	public void refresh() {
		
	}

}
