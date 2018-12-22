package fr.jrich.pvpswap.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.ThunderChangeEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;

public class ThunderChange extends PvPSwapListener {

    public ThunderChange(final PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onThunderChange(final ThunderChangeEvent event) {
        if (event.toThunderState()) {
            event.setCancelled(true);
        }
    }
}
