package fr.jrich.pvpswap.event.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class FoodLevelChange extends PvPSwapListener {

    public FoodLevelChange(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }
}
