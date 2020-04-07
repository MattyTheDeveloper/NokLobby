package org.Nokwok.Events;

import org.Nokwok.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class onPvP implements Listener {

    Main plugin;

    public onPvP(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPvp(EntityDamageByEntityEvent e) {
        if (plugin.getConfig().getString("PVP").equalsIgnoreCase("false")) {
            e.setCancelled(true);
        } if (plugin.getConfig().getString("PVP").equalsIgnoreCase("true")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e ) {
        e.setCancelled(true);
    }

}
