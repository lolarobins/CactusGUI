package ca.cactusmc.gui;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;


/**
 * The base for any animated background.
 * <p>
 * The constructor of an animated background must include {@link #setTickSpeed(int)}, and your {@link #draw()} method must end with {@link #doNextUpdate()}.
 * @author mwmxt
 *
 */
public abstract class AnimatedBackground extends Background {
	
	protected int tick;
	protected HashMap<Integer, GUIItem> frame = new HashMap<Integer, GUIItem>();
	protected boolean stop;
	
	/**
	 * Gets the time between each update.
	 * @return the ticks between each update.
	 */
	public int getTickSpeed() {return this.tick;}
	
	/**
	 * Sets the time (in ticks) between each update.
	 * @param tick Delay to set.
	 */
	public void setTickSpeed(int tick) {
		if(tick < 1) {
			this.tick = 1;
			Bukkit.getServer().getLogger().log(Level.SEVERE, "INVALID TICKRATE SPECIFIED FOR CACTUS GUI ANIMATION. TICK RATE MUST BE > 0. AUTOMATICALLY SET TO 1 TO PREVENT CRASHES.");
			return;
		}else {
			this.tick = tick;
		}
	}
	
	/**
	 * Stops the animation from updating.
	 */
	public void stop() {this.stop = true;}
	
	public HashMap<Integer, GUIItem> currentAnimationFrame() {return this.frame;}
	
	public void doNextUpdate() {
		if(!stop)Bukkit.getScheduler().runTaskLater(CactusGUIHook.getHookedPlugin(), new Runnable() {
			@Override
			public void run() {
				draw();
			}
		}, tick);
	}
	
	

}
