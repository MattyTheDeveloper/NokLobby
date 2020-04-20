package org.Nokwok.Events;

import net.milkbowl.vault.chat.Chat;
import org.Nokwok.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class onPvP implements Listener {

    Main plugin;
    private Chat chat = null;

    public onPvP(Main main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onPvp(EntityDamageByEntityEvent e) {
        if (plugin.getConfig().getString("Pvp.All").equals(false)) {
            e.setCancelled(false);
            if (plugin.getConfig().getString("Pvp.Player").equals(false)) {
                e.setCancelled(false);
            } else {
                if (e.getEntityType().equals(EntityType.PLAYER)) {
                    e.setCancelled(true);
                } else {
                    e.setCancelled(false);
                }
            }
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            Entity p = e.getEntity();
            Bukkit.getServer().dispatchCommand(p, "spawn");
        } else if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

}
