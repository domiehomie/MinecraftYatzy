package live.mufin.yatzy.commands;

import live.mufin.MufinCore.commands.MCM;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OpenInvGUI implements CommandExecutor, MCM {
    @Override
    public String commandName() {
        return null;
    }

    @Override
    public String[] commandAliases() {
        return new String[0];
    }

    @Override
    public String usage() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String permission() {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
