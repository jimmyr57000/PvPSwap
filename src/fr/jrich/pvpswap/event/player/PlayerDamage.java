package fr.jrich.pvpswap.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class PlayerDamage extends PvPSwapListener {

    public PlayerDamage(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && SpectatorUtils.isSpectator((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }
}
