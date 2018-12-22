package fr.jrich.pvpswap.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class PlayerItemConsume extends PvPSwapListener {

    public PlayerItemConsume(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent evt) {
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(evt.getPlayer())) {
            evt.setCancelled(true);
        }
    }
}
