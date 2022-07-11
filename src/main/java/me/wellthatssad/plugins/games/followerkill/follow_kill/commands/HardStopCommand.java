package me.wellthatssad.plugins.games.followerkill.follow_kill.commands;

import me.wellthatssad.plugins.games.followerkill.follow_kill.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HardStopCommand implements CommandExecutor {
    Main main = Main.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1)//if I have to write this one more time I am going to commit a horrendous crime
        {
            sender.sendMessage(ChatColor.BOLD + (ChatColor.GOLD + "THIS IS AN EMERGENCY COMMAND AND WILL MAKE" +
                    " THE PLUGIN UNUSABLE UNTIL RELOADING THE SERVER"));
            sender.sendMessage(ChatColor.BOLD + (ChatColor.RED + "IF YOU ARE SURE ABOUT THIS RUN /hardstop confirm"));

        }
        else if(args[0].equalsIgnoreCase("confirm")){
            main.setHasStopped(true);
            sender.sendMessage(ChatColor.GOLD + "Game cancelled");
        }
        return false;
    }
    //this is an emergency command(server overload type deal) and won't be used if the code I wrote is all right
    // (it probably will be used)


}
