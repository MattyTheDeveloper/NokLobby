package org.Nokwok.Events;



import org.Nokwok.Main;

import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class firstJoin implements Listener {
Main plugin;

    public firstJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler

    public void firstJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if (p.hasPermission("event.firstjoin")) {
            if (!p.hasPlayedBefore()) {
                ItemStack server = new ItemStack(Material.COMPASS);
                ItemMeta servermeta = server.getItemMeta();
                servermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Server List"));
                ArrayList<String> serverlore = new ArrayList<>();
                serverlore.add(ChatColor.translateAlternateColorCodes('&', "&7Server List"));
                servermeta.setLore(serverlore);
                p.getInventory().addItem(server);
                // GUI BELOW - PLEASE EDIT TO YOUR LIKING.
                Inventory serverinv = Bukkit.createInventory(p, 9, ChatColor.GRAY + "Server list");
                ItemStack events = new ItemStack(Material.FIREWORK_ROCKET);
                ItemStack smp = new ItemStack(Material.GOLDEN_SHOVEL);
                ItemStack othergamemode = new ItemStack(Material.GRASS); 
                // This is a placeholder, please edit accordingly.
                
                ItemMeta eventmeta = events.getItemMeta();
                eventmeta.setDisplayName(ChatColor.RED + "Events");
                ArrayList eventlore = new ArrayList();
                eventlore.add(ChatColor.RED + "This is where events will happen.");
                eventmeta.setLore(eventlore);
                
                ItemMeta smpmeta = smp.getItemMeta();
                smpmeta.setDisplayName(ChatColor.RED + "SMP");
                ArrayList smplore = new ArrayList();
                smplore.add(ChatColor.RED + "Survival Multiplayer");
                smpmeta.setLore(smplore);
                
                ItemMeta othergamemodemeta = othergamemode.getItemMeta();
                othergamemodemeta.setDisplayName(ChatColor.RED + "PLACEHOLDER");
                ArrayList othergamemodelore = new ArrayList();
                othergamemodelore.add(ChatColor.RED + "PLACEHOLDER");
                othergamemodemeta.setLore(othergamemodelore);
                // Updated, should work now. -Hit.
                serverinv.setItem(2, events);
                serverinv.setItem(4, smp);
                serverinv.setItem(6, PLACEHOLDER);
                
                
            }
        }
    }
}

