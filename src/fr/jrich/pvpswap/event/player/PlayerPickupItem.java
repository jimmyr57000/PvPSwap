package fr.jrich.pvpswap.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class PlayerPickupItem extends PvPSwapListener {

    public PlayerPickupItem(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
