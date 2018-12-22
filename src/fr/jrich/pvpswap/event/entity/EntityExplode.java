package fr.jrich.pvpswap.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;

public class EntityExplode extends PvPSwapListener {

    public EntityExplode(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (Step.isStep(Step.LOBBY)) {
            event.setCancelled(true);
        }
    }
}
