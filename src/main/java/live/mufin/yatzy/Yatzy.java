package live.mufin.yatzy;

import live.mufin.MufinCore.MufinCore;
import live.mufin.yatzy.commands.ChallengeCommand;
import live.mufin.yatzy.datatypes.Game;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Yatzy extends JavaPlugin {

    public static MufinCore core;
    public static List<Game> games = new ArrayList<>();
    private static Yatzy instance;

    public static Yatzy getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        core = new MufinCore(this, "Yatzy", ChatColor.DARK_GREEN, "YA");
        instance = this;
        core.registerCommand(new ChallengeCommand());
        getCommand("challenge").setExecutor(new ChallengeCommand());
        getServer().getPluginManager().registerEvents(new GameHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
