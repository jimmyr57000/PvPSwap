package fr.jrich.pvpswap.event.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class EntityDamageByPlayer extends PvPSwapListener {

    public EntityDamageByPlayer(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onEntityDamageByPlayer(EntityDamageByEntityEvent event) {
        if (!Step.isStep(Step.IN_GAME) || event.getDamager() instanceof Player && SpectatorUtils.isSpectator((Player) event.getDamager())) {
            event.setCancelled(true);
        }
    }
}
