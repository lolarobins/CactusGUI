package ca.liamrobins.gui;

/**
 * Click types for actions called upon when a player clicks an item in a gui.
 * @author CCMW
 */
public enum GUIClickType {
	/**
	 * Runs on any clicktype.
	 */
	ANY,
	/**
	 * Player left clicks an item.
	 */
	LEFT_CLICK,
	/**
	 * Player right clicks an item.
	 */
	RIGHT_CLICK,
	/**
	 * Player shift left clicks an item.
	 */
	SHIFT_LEFT_CLICK,
	/**
	 * Player shift right clicks an item. 
	 */
	SHIFT_RIGHT_CLICK,
	/**
	 * Player middle clicks an item.
	 */
	MIDDLE_CLICK,
	/**
	 * Player presses Q (drops item)
	 */
	Q,
	/**
	 * Player presses Control+Q (shift drop item)
	 */
	CONTROL_Q,
	/**
	 * Player presses F (swap to offhand)
	 */
	F,
	/**
	 * Player presses a number key.
	 */
	NUMBER;
}
