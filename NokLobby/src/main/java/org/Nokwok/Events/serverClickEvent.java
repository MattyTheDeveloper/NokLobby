package org.Nokwok.Events;

import me.hitthetarget56.hitscoregui.HitsCoreGUI;
import org.Nokwok.Main;
import org.bukkit.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class serverClickEvent implements Listener {
Main plugin;

    public serverClickEvent(Main plugin) {
        this.plugin = plugin;
    }
    public void onClick(InventoryClickEvent e){
            Player p = (Player) e.getWhoClicked();
            // I know using performCommand(); is a bad way of doing it, I don't have a lot of time today so ill figure out a better way tomorrow.
        if (e.getClickedInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&7Server list"))){
          switch (e.getCurrentItem().getType()) {
              case FIREWORK:
                  p.sendMessage(ChatColor.GREEN + "Sending you to Events.");
                  p.performCommand("server smp");
                  break;
              case GOLD_SPADE:
                  p.sendMessage((ChatColor.GREEN + "Sending you to SMP."));
                  p.performCommand("server smp");
                  break;
              case DIRT:
                  p.sendMessage(ChatColor.RED + "PLACEHOLDER - NOT CODED YET.");
                  break;
            }
          }
    }

}
