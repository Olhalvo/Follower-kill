package me.wellthatssad.plugins.games.followerkill.follow_kill.commands;

import me.wellthatssad.plugins.games.followerkill.follow_kill.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Main main = Main.getInstance();

        if(main.getUsername().equalsIgnoreCase("\u0000"))
        {
            sender.sendMessage(ChatColor.BOLD + (ChatColor.RED + "First set a name with /setname <Twitch username>"));
            return true;
        }
        else
        {
            main.setOn(true);

            sender.sendMessage(ChatColor.GOLD + "Game started");
            return true;
        }
    }
}
