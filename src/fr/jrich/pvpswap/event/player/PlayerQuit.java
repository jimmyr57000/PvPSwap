package fr.jrich.pvpswap.event.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.scheduler.BeginCountdown;
import fr.jrich.pvpswap.util.SpectatorUtils;
import fr.jrich.pvpswap.util.StatsUtils;

public class PlayerQuit extends PvPSwapListener {

    public PlayerQuit(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        BeginCountdown.resetPlayer(event.getPlayer());
        if (Step.isStep(Step.IN_GAME) && !SpectatorUtils.isSpectator(event.getPlayer())) {
            Bukkit.broadcastMessage(PvPSwapPlugin.prefix + event.getPlayer().getName() + ChatColor.GRAY + " est mort en se déconnectant.");
        }
        if (!Step.isStep(Step.LOBBY)) {
            StatsUtils.showStatsMessage(event.getPlayer());
        }
        plugin.onPlayerLoose(event.getPlayer());
    }
}
