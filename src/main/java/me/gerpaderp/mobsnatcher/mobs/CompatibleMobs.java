package me.gerpaderp.mobsnatcher.mobs;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.HashMap;

public interface CompatibleMobs {

    HashMap<EntityType, Material> getMobs();

}
