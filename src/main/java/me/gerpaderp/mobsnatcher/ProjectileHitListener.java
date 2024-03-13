package me.gerpaderp.mobsnatcher;

import me.gerpaderp.mobsnatcher.mobs.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class ProjectileHitListener implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        if (event.getHitEntity() == null) return;

        if (!(event.getHitEntity() instanceof Mob)) return;

        CompatibleMobs compatibleMobs = null;

        String version = Bukkit.getVersion().split("-")[0];

        if (version.contains("1.16")) {
            compatibleMobs = new CompatibleMobs_1_16();
        } else if (version.contains("1.17")) {
            compatibleMobs = new CompatibleMobs_1_17();
        } else if (version.contains("1.18")) {
            compatibleMobs = new CompatibleMobs_1_18();
        } else if (version.contains("1.19")) {
            compatibleMobs = new CompatibleMobs_1_19();
        } else if (version.contains("1.20")) {
            compatibleMobs = new CompatibleMobs_1_20();
        }

        //warn console unspported version
        if (compatibleMobs == null) return;

        Projectile projectile = event.getEntity();

        if (!(projectile instanceof Egg)) return;

        Egg egg = (Egg) projectile;

        ProjectileSource source = egg.getShooter();

        if (!(source instanceof Player)) return;

        Player player = (Player) source;





    }
}
