package live.mufin.yatzy;

import live.mufin.yatzy.GUI.GameGUI;
import live.mufin.yatzy.GUI.Items;
import live.mufin.yatzy.datatypes.Dice;
import live.mufin.yatzy.datatypes.Game;
import live.mufin.yatzy.datatypes.GamePlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class GameHandler implements Listener {
    public static Game createGame(List<Player> players) {
        List<GamePlayer> gamePlayers = new ArrayList<>();

        for (Player player : players) {
            LinkedList<Dice> die = new LinkedList<>();
            die.add(new Dice(0, false));
            die.add(new Dice(0, false));
            die.add(new Dice(0, false));
            die.add(new Dice(0, false));
            die.add(new Dice(0, false));
            gamePlayers.add(new GamePlayer(player, die, null, 0));
        }

        Game game = new Game(gamePlayers.toArray(GamePlayer[]::new), UUID.randomUUID());
        Yatzy.games.add(game);
        return game;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!ChatColor.stripColor(e.getView().getTitle()).equals("Yatzy")) return;
        e.setCancelled(true);
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        if(e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(Items.key, PersistentDataType.STRING).equals("ROLL")) {
            for(Game game : Yatzy.games) {
                for(GamePlayer player : game.getPlayers()) {
                    if(player.getPlayer().getUniqueId() == e.getView().getPlayer().getUniqueId()) {
                        Random random = new Random();
                        for(Dice dice : player.getDie()) {
                            int i = random.nextInt(6) + 1;
                            dice.setNumber(i);
                        }
                        GameGUI.createYatzyInventory(game);
                    }
                }
            }
        }

    }
}
