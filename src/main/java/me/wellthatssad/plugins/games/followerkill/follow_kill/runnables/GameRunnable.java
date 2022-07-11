package me.wellthatssad.plugins.games.followerkill.follow_kill.runnables;

import me.wellthatssad.plugins.games.followerkill.follow_kill.Main;
import me.wellthatssad.plugins.games.followerkill.follow_kill.imports.GetFollowerClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameRunnable extends BukkitRunnable {
    GetFollowerClass getFollowerClass;
    final Main instance = Main.getInstance();
    long runs = 0;
    int prevFollowers;

    @Override
    public void run() {
        if(instance.isHasStopped()){
            instance.getLogger().info("Game hardstopped");
            this.cancel();
        }
        int tempFollowers;
        if(!instance.isOn()){
            runs = 0;
            return;
        }
        if(runs == 0){
            Bukkit.broadcastMessage("initializing class with username: " + instance.getUsername());
            getFollowerClass = new GetFollowerClass(instance.getUsername());
            prevFollowers = getFollowerClass.run();
            runs++;
            return;
        }
        tempFollowers = getFollowerClass.run();
        if(tempFollowers > prevFollowers)
        {
            for(Player p: Bukkit.getOnlinePlayers())
            {
                p.damage(Integer.MAX_VALUE);
            }
        }
        prevFollowers = tempFollowers;
        runs++;
    }
}
