package org.Nokwok.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class onJoinGUI implements Listener {

    @EventHandler
    public void onJoinGUI(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        p.getInventory().clear();

        ItemStack server = new ItemStack(Material.COMPASS);
        ItemMeta servermeta = server.getItemMeta();
        servermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Server List"));
        server.setItemMeta(servermeta);
        p.getInventory().setItem(4, server);
    }
}
