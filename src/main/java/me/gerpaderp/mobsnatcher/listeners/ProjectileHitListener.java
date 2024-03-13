package me.gerpaderp.mobsnatcher.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class ProjectileHitListener implements Listener {


    @EventHandler
    public void onEggHit(ProjectileHitEvent event) {

        if (event.isCancelled()) return;
        if (!(event.getEntity() instanceof Egg)) return;

        Egg egg = (Egg) event.getEntity();

        if (!(egg.getShooter() instanceof Player)) return;

        Player player = (Player) egg.getShooter();

        if (!(event.getHitEntity() instanceof LivingEntity)) return;

        LivingEntity hitEntity = (LivingEntity) event.getHitEntity();

        snatchMob(player, hitEntity);
    }

    public void snatchMob(Player player, LivingEntity livingEntity) {

        EntityType entityType = livingEntity.getType();
        Material spawnEggMaterial = Material.matchMaterial(entityType.name() + "_SPAWN_EGG");

        if (spawnEggMaterial == null) {
            //spawn egg doesn't exist for this mob type
            return;
        }

        //check for player permission to catch mobs
        //check if mob is valid for this version

        ItemStack spawnEggItem = new ItemStack(spawnEggMaterial, 1);

        World mobWorld = livingEntity.getWorld();
        Location mobLocation = livingEntity.getLocation();

        livingEntity.remove();

        mobWorld.dropItemNaturally(mobLocation, spawnEggItem);
        //successfully caught
    }

}
