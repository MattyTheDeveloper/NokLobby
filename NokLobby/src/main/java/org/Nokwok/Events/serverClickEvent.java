package org.Nokwok.Events;

import me.hitthetarget56.hitscoregui.HitsCoreGUI;
import org.Nokwok.Main;
import org.bukkit.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.material;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class serverClickEvent implements Listener {
Main plugin;

    public serverClickEvent(Main plugin) {
        this.plugin = plugin;
    }
    public void onClick(InventoryClickEvent e){
            Player p = (Player) e.getWhoClicked();
            String smpcmd = "server smp";
            String eventscmd = "server events"
            //  Should work now. -Hit
        if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&3Server list"))){
                if(e.getCurrentItem() == null){
                    return;
                }else if(e.getCurrentItem().getType().equals(Material.GOLD_SPADE)){
                    p.performCommand(smpcmd);
                    p.sendMessage(ChatColor.RED + "Sending you to SMP.")
                }else if(e.getCurrentItem().getType().equals(Material.FIREWORK)){
                    p.performCommand(eventscmd);
                    p.sendMessage(ChatColor.RED + "You cannot connect to this server right now. An event is not active.")
                }else if(e.getCurrentItem().getType().equals(Material.GRASS)){
                    p.sendMessage(ChatColor.RED + "I cannot do this right now. If you are a developer+, please inspect the code under serverClickEvent.java!")
                }
               
        
        }
           
          }
    }

}
