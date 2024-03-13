package me.gerpaderp.mobsnatcher.listeners;

import me.gerpaderp.mobsnatcher.MobSnatcher;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ProjectileHitListener implements Listener {


    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        //if (event.isCancelled()) return;

        //verify projectile is a snatcher
        if (!isMobSnatcher(event.getEntity())) return;
        Projectile snatcher = event.getEntity();

        //verify shooter is a player
        if (!(snatcher.getShooter() instanceof Player)) return;
        Player player = (Player) snatcher.getShooter();

        //verify target is living
        if (!(event.getHitEntity() instanceof LivingEntity)) return;
        LivingEntity hitEntity = (LivingEntity) event.getHitEntity();

        //verify target has a spawn egg
        EntityType entityType = hitEntity.getType();
        Material spawnEggMaterial = Material.matchMaterial(entityType.name() + "_SPAWN_EGG");
        if (spawnEggMaterial == null) return;

        //verify player is allowed to snatch this mob
        if (!canSnatch(player, hitEntity)) return;

        //successful snatch logic
        ItemStack spawnEggItem = new ItemStack(spawnEggMaterial, 1);
        World snatchWorld = hitEntity.getWorld();
        Location snatchLocation = hitEntity.getLocation();
        hitEntity.remove();
        snatchWorld.dropItemNaturally(snatchLocation, spawnEggItem);
        snatcher.remove();


    }

    //make logic
    public boolean canSnatch(Player player, LivingEntity livingEntity) {

        FileConfiguration config = MobSnatcher.getInstance().getConfig();

        //verify world is not disabled
        List<String> disabledWorlds = config.getStringList("disabled-worlds");
        if (disabledWorlds.contains(livingEntity.getWorld().getName())) return false;

        //verify mob is not disabled
        List<String> disabledMobs = config.getStringList("disabled-mobs");
        if (disabledMobs.contains(livingEntity.getType().name())) return false;

        //verify player has permission
        if (!player.hasPermission("mobsnatcher.snatch")) return false;

        return true;
    }

    //make logic
    public boolean isMobSnatcher(ItemStack itemStack) {
        return true;
    }

    //make logic
    public boolean isMobSnatcher(Projectile projectile) {
        if (!(projectile.getType() == EntityType.EGG)) return false;
        //check persistent data
        return true;
    }

}
