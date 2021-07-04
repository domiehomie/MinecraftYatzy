package live.mufin.yatzy.GUI;

import live.mufin.yatzy.datatypes.Dice;
import live.mufin.yatzy.datatypes.Game;
import live.mufin.yatzy.datatypes.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameGUI {

    public static void createYatzyInventory(Game game) {
        GamePlayer[] players = game.getPlayers();
        for (GamePlayer pl : players) {
            GamePlayer player = game.getCurrentPlayer();
            Player p = pl.getPlayer();
            Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GREEN + "Yatzy");
            inv.setItem(0, Items.ones(player));
            inv.setItem(1, Items.twos(player));
            inv.setItem(2, Items.threes(player));
            inv.setItem(3, Items.fours(player));
            inv.setItem(4, Items.fives(player));
            inv.setItem(5, Items.sixes(player));
            inv.setItem(6, Items.pane);
            inv.setItem(7, Items.pane);
            inv.setItem(8, Items.pane);

            inv.setItem(15, Items.pane);
            inv.setItem(16, Items.pane);

            inv.setItem(18, Items.threeOfAKind(player));
            inv.setItem(19, Items.fourOfAKind(player));
            inv.setItem(20, Items.fullHouse(player));
            inv.setItem(21, Items.smallStreet(player));
            inv.setItem(22, Items.bigStreet(player));
            inv.setItem(23, Items.yatzy(player));
            inv.setItem(24, Items.chance(player));
            inv.setItem(25, Items.pane);

            inv.setItem(34, Items.pane);

            inv.setItem(36, Items.pane);
            inv.setItem(37, Items.pane);
            inv.setItem(38, Items.pane);
            inv.setItem(39, Items.pane);
            inv.setItem(40, Items.pane);
            inv.setItem(41, Items.pane);
            inv.setItem(42, Items.pane);
            inv.setItem(43, Items.pane);

//            for (int i = 0; i < 5; i++) {
//                try {
//                    inv.setItem((i + 8) + 9, Items.statsItem(game.getPlayers()[i]));
//                } catch (IndexOutOfBoundsException e) {
//                    break;
//                }
//            }

            for (int i = 0; i < player.getDie().size(); i++) {
                inv.setItem(i + 45, Items.diceItem(player.getDie().get(i)));
            }

            inv.setItem(50, Items.roll(game));
            inv.setItem(51, Items.statsItem(player));
            inv.setItem(52, Items.pane);
            p.openInventory(inv);
        }
    }
}
