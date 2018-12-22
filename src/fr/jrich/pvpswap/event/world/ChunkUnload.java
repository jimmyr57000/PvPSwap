package fr.jrich.pvpswap.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkUnloadEvent;

import fr.jrich.pvpswap.PvPSwapListener;
import fr.jrich.pvpswap.PvPSwapPlugin;

public class ChunkUnload extends PvPSwapListener {

    public ChunkUnload(PvPSwapPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        event.setCancelled(true);
    }
}
