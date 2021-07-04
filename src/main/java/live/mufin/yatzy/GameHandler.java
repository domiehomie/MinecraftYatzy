package live.mufin.yatzy;

import live.mufin.yatzy.GUI.GameGUI;
import live.mufin.yatzy.GUI.Items;
import live.mufin.yatzy.datatypes.Dice;
import live.mufin.yatzy.datatypes.Game;
import live.mufin.yatzy.datatypes.GamePlayer;
import live.mufin.yatzy.enums.ScoreOption;
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
            gamePlayers.add(new GamePlayer(player, die, 0));
        }

        Game game = new Game(gamePlayers.toArray(GamePlayer[]::new), UUID.randomUUID());
        Yatzy.games.add(game);
        return game;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!ChatColor.stripColor(e.getView().getTitle()).equals("Yatzy")) return;
        e.setCancelled(true);
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        GamePlayer p = getPlayer(e.getWhoClicked().getUniqueId());
        Game g = p.getGame();

        if(g == null) return;
        if(!g.getCurrentPlayer().getPlayer().getUniqueId().equals(e.getWhoClicked().getUniqueId())) return;
        if(!e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Items.key, PersistentDataType.STRING)) return;
        switch (e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(Items.key, PersistentDataType.STRING)) {
            case "ROLL": {
                if(g.getCurrentTurn() >= 3) {
                    Yatzy.core.sendFormattedMessage(e.getWhoClicked(), "&cYou can only roll three times.");
                    return;
                }
                Random random = new Random();
                for (Dice dice : p.getDie()) {
                    int i = random.nextInt(6) + 1;
                    if(!dice.isHeld()) dice.setNumber(i);
                }
                g.nextTurn();
                GameGUI.createYatzyInventory(g);
                break;
            }
            case "DICE": {
                int dice = e.getSlot() - 45;
                if(dice >= 0 && dice <= 4) {
                    Dice d = p.getDie().get(dice);
                    d.setHeld(!d.isHeld());
                    GameGUI.createYatzyInventory(g);
                }
                break;
            }
            default: {
                if(!e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Items.key, PersistentDataType.STRING)) break;
                System.out.print(e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(Items.key, PersistentDataType.STRING));
                ScoreOption option = ScoreOption.valueOf(e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(Items.key, PersistentDataType.STRING));
                if(p.getScores().containsKey(option)) return;
                int value = getScore(p, option);
                p.getScores().put(option, value);
                g.nextPlayer();
                g.resetTurn();

                p.setTotalScore(p.getTotalScore() + value);

                p.getDie().forEach(dice -> {
                    dice.setNumber(0);
                    dice.setHeld(false);
                });
                GameGUI.createYatzyInventory(g);
            }
        }
    }

    public static GamePlayer getPlayer(UUID uuid) {
        for (Game game : Yatzy.games) {
            for (GamePlayer player : game.getPlayers()) {
                if (player.getPlayer().getUniqueId() == uuid) {
                    return player;
                }
            }
        }
        return null;
    }
    public static int getScore(GamePlayer p, ScoreOption option) {
        int value = -1;
        switch (option) {
            case ONES -> {
                if(Validating.ones(p))
                    value = points(1, p);
            }
            case TWOS -> {
                if(Validating.twos(p))
                    value = points(2, p);
            }
            case THREES -> {
                if(Validating.threes(p))
                    value = points(3, p);
            }
            case FOURS -> {
                if(Validating.fours(p))
                    value = points(4, p);
            }
            case FIVES -> {
                if(Validating.fives(p))
                    value = points(5, p);
            }
            case SIXES -> {
                if(Validating.sixes(p))
                    value = points(6, p);
            }
            case THREE_OF_A_KIND -> {
                if(Validating.threeOfAKind(p))
                    value = total(p);
            }
            case FOUR_OF_A_KIND -> {
                if(Validating.fourOfAKind(p))
                    value = total(p);
            }
            case FULL_HOUSE -> {
                if(Validating.fullHouse(p))
                    value = option.value;
            }
            case SMALL_STRAIGHT -> {
                if(Validating.smallStraight(p))
                    value = option.value;
            }
            case LARGE_STRAIGHT -> {
                if(Validating.bigStraight(p))
                    value = option.value;
            }
            case YATZY -> {
                if(Validating.yatzy(p))
                    value = option.value;
            }
            case CHANCE -> value = total(p);
        }
        return value;
    }

    private static int points(int amount, GamePlayer p) {
        int i = 0;
        for(Dice d : p.getDie()) {
            if(d.getNumber() == amount) i = i + amount;
        }
        return i;
    }
    private static int total(GamePlayer p) {
        int i = 0;
        for (Dice die : p.getDie()) {
            i = i + die.getNumber();
        }
        return i;
    }
}
