package live.mufin.yatzy.commands;

import live.mufin.MufinCore.commands.MCM;
import live.mufin.yatzy.GUI.GameGUI;
import live.mufin.yatzy.GameHandler;
import live.mufin.yatzy.datatypes.Game;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChallengeCommand implements CommandExecutor, MCM {
    @Override
    public String commandName() {
        return "challenge";
    }

    @Override
    public String[] commandAliases() {
        return null;
    }

    @Override
    public String usage() {
        return "/challenge <player>";
    }

    @Override
    public String description() {
        return "Lets you challenge someone to a game of yatzy!";
    }

    @Override
    public String permission() {
        return "yatzy.challenge";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        List<Player> players = new ArrayList<>();
        for (String arg : args) {
            players.add(Bukkit.getPlayer(arg));
        }
        players.add((Player) sender);
        Game game = GameHandler.createGame(players);
        GameGUI.createYatzyInventory(game);
        System.out.println(game.toString());
        return true;
    }
}
