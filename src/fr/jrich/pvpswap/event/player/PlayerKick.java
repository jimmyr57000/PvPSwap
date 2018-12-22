package fr.jrich.pvpswap.event.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerKickEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.scheduler.BeginCountdown;
import fr.jrich.pvpswap.util.SpectatorUtils;
import fr.jrich.pvpswap.util.StatsUtils;

public class PlayerKick extends PvPSwapListener {

    public PlayerKick(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        event.setLeaveMessage(null);
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
