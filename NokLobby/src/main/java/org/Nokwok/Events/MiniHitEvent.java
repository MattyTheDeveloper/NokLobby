package org.Nokwok.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MiniHitEvent implements Listener {
    @EventHandler
    public void onMiniHit(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player p = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();
            if (p.getDisplayName().equals("MiniMuka")){
                e.setCancelled(false);
            }else{
                e.setCancelled(true);
                damager.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lHey! &7You can only hit 'MiniMuka'!"));
            }
        }
    }
    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player p = (Player) e.getEntity();
            Player personwhohit = (Player) e.getDamager();
            if (personwhohit.getDisplayName().equals("MiniMuka")){
                e.setCancelled(false);
            }else{
                e.setCancelled(true);
            }
        }
    }


}
