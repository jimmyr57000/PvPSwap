package fr.jrich.pvpswap.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.bukkit.Location;

@Data
@AllArgsConstructor
public class MapLocation {
    private String map;
    private Location location;
}
