package fr.jrich.pvpswap.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class PlayerDropItem extends PvPSwapListener {

    public PlayerDropItem(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
