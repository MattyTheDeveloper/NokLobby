package org.nokwok.nokwokminievent.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DrownEvent implements Listener {
    public void onDrown(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
                e.setCancelled(true);

            }else{
                e.setCancelled(false);
            }
        }
    }
}
