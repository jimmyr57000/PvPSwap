package fr.jrich.pvpswap.event.player;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.scheduler.GameRunnable;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class PlayerMove extends PvPSwapListener {

    public PlayerMove(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();
        if (from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) {
            if (Step.isStep(Step.IN_GAME) && GameRunnable.swapCount == 0 && from.getBlockY() == to.getBlockY()) {
                event.setTo(event.getFrom());
            } else if (to.getBlockY() <= 0 && (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(event.getPlayer()))) {
                event.getPlayer().sendMessage(PvPSwapPlugin.prefix + "Vous ne pouvez pas sortir de la WaitingRoom");
                event.getPlayer().teleport(plugin.getLobbyLocation());
            }
        }
    }
}
