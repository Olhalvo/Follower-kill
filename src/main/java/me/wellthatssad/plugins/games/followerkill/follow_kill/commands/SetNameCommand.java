package me.wellthatssad.plugins.games.followerkill.follow_kill.commands;

import me.wellthatssad.plugins.games.followerkill.follow_kill.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetNameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Main main = Main.getInstance();

        // end my suffering please
        if(args.length < 1){
            sender.sendMessage(ChatColor.BOLD + (ChatColor.RED + "usage: /setname <Twitch Username>"));
            return true;
        }
        else
        {
            main.setUsername(args[0]);

            sender.sendMessage(ChatColor.GOLD + "username was set to " + args[0]);
            return true;
        }

    }
}
