package fr.jrich.pvpswap.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;
import fr.jrich.pvpswap.handler.Step;
import fr.jrich.pvpswap.util.SpectatorUtils;

public class BlockBreak extends PvPSwapListener {

    public BlockBreak(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (Step.isStep(Step.LOBBY) || SpectatorUtils.isSpectator(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
