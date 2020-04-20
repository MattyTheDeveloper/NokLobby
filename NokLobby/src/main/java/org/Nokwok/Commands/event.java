package org.Nokwok.Commands;

import org.Nokwok.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class event implements CommandExecutor {

    Main plugin;

    public event(Main instance) {

        plugin = instance;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player only command");
        } else {
            if (p.hasPermission(plugin.getConfig().getString("Lobby.Command.event"))) {
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("set")) {
                        plugin.getConfig().set("Event", args[1]);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "holo setline Portal1 3 &bEvent: &3"+plugin.getConfig().getString("Event"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Event updated to: &b"+args[1]));
                    } else {
                        p.sendMessage(ChatColor.RED + "Incorrect usage: /event (set) (new name)");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Incorrect usage: /event (set) (new name)");
                }
            } else {
                p.sendMessage(plugin.getConfig().getString("Permission.message"));
                p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH, 1.0F, 0.5F);
            }

        }


        return false;
    }
}
