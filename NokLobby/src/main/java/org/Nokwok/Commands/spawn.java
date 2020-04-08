package org.Nokwok.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Checking if the sender is a player. 
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Only players can execute this!");
        }else {
            Player p = (Player) sender;
            // Checking if the player has the correct permissions.
            if (!p.hasPermission("command.spawn")) {
                p.sendMessage(ChatColor.RED + "You cannot use this command.");
            } else {
                // Getting the worlds spawn location.
                Location spawn = p.getWorld().getSpawnLocation();
                // TPs the user to that location.
                p.teleport(spawn);
                p.sendMessage(ChatColor.GREEN + "You have been teleported to spawn.");
            }
        }
        return false;
    }
}
