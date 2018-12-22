package fr.jrich.pvpswap.event.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class InventoryClick extends PvPSwapListener {

    public InventoryClick(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(player)) {
            event.setCancelled(true);
            if (event.getInventory().getName().contains("Menu Spectateur") && event.getRawSlot() == event.getSlot()) {
                ItemStack item = event.getCurrentItem();
                if (item != null && item.getType() == Material.SKULL_ITEM) {
                    player.closeInventory();
                    Player alive = Bukkit.getPlayer(ChatColor.stripColor(item.getItemMeta().getDisplayName()));
                    if (!alive.isOnline()) {
                        player.sendMessage(ChatColor.GRAY + "Ce joueur n'est plus en ligne !");
                    } else {
                        player.teleport(alive);
                    }
                }
            }
        }
    }
}
