package org.Nokwok.Commands;

import org.Nokwok.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class elytra implements CommandExecutor {

    Main plugin;

    public elytra(Main instance) {

        plugin = instance;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player only command");
        } else {
            if (p.hasPermission(plugin.getConfig().getString("Lobby.Command.elytra"))) {
                p.sendMessage(ChatColor.GRAY+"Woosh!");
                p.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                p.setVelocity(new Vector(0, 18, 0));
                p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 3.0F, 0.5F);
            } else {
                p.sendMessage(plugin.getConfig().getString("Permission.message"));
                p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH, 1.0F, 0.5F);
            }
        }

        return false;
    }

}


