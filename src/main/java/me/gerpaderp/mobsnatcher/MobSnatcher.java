package me.gerpaderp.mobsnatcher;

import me.gerpaderp.mobsnatcher.listeners.ProjectileHitListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class MobSnatcher extends JavaPlugin {

    //private static MobSnatcher instance;
    //NamespacedKey mobSnatcherKey = new NamespacedKey(MobSnatcher.getInstance(), "egg");

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ProjectileHitListener(), this);
        // Plugin startup logic
        //instance = this;

       /* ItemStack item = new ItemStack(Material.EGG);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Mob Snatcher");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(mobSnatcherKey, PersistentDataType.STRING, "mobsnatcher");
        item.setItemMeta(meta);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        ShapedRecipe eggRecipe = new ShapedRecipe(mobSnatcherKey, item);

        eggRecipe.shape(" R ", "RER", " R ");
        eggRecipe.setIngredient('R', Material.REDSTONE);
        eggRecipe.setIngredient('E', Material.EGG);

        Bukkit.addRecipe(eggRecipe);*/


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /*public static MobSnatcher getInstance() {
        return instance;
    }

    Set<Material> spawnEggs = Arrays.stream(Material.values()).filter(material -> material.name().endsWith("_SPAWN_EGG")).collect(Collectors.toSet());
    */

}
