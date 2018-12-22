package fr.jrich.pvpswap.event.player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.scheduler.GameRunnable;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class AsyncPlayerChat extends PvPSwapListener {
    public static List<UUID> specs = new ArrayList<>();

    public AsyncPlayerChat(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (Step.isStep(Step.IN_GAME) && GameRunnable.swapCount > 0 && SpectatorUtils.isSpectator(player)) {
            if (AsyncPlayerChat.specs.contains(player.getUniqueId())) {
                event.setCancelled(true);
                player.sendMessage(PvPSwapPlugin.prefix + ChatColor.RED + "Vous ne pouvez pas parler. " + ChatColor.WHITE + "Attendez un kill ! =)");
                return;
            }
            AsyncPlayerChat.specs.add(player.getUniqueId());
        }
        event.setFormat(ChatColor.GRAY + "[" + (!Step.isStep(Step.LOBBY) && SpectatorUtils.isSpectator(player) ? ChatColor.DARK_GRAY + "Spectateur" : ChatColor.WHITE + "Joueur") + ChatColor.GRAY + "] " + ChatColor.WHITE + player.getName() + ": " + event.getMessage());
    }
}
