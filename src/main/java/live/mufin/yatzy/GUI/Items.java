package live.mufin.yatzy.GUI;

import live.mufin.yatzy.Validating;
import live.mufin.yatzy.Yatzy;
import live.mufin.yatzy.datatypes.Dice;
import live.mufin.yatzy.datatypes.Game;
import live.mufin.yatzy.datatypes.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Items {

    public static NamespacedKey key = new NamespacedKey(Yatzy.getInstance(), "id");

    public static ItemStack ones(GamePlayer p) {
        if(Validating.ones(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Ones");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Ones");
    }
    public static ItemStack twos(GamePlayer p) {
        if(Validating.twos(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Twos");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Twos");
    }
    public static ItemStack threes(GamePlayer p) {
        if(Validating.threes(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Threes");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Threes");
    }
    public static ItemStack fours(GamePlayer p) {
        if(Validating.fours(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Fours");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Fours");
    }
    public static ItemStack fives(GamePlayer p) {
        if(Validating.fives(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Fives");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Fives");
    }
    public static ItemStack sixes(GamePlayer p) {
        if(Validating.sixes(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Sixes");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Sixes");
    }
    public static ItemStack threeOfAKind(GamePlayer p) {
        if(Validating.threeOfAKind(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three of a Kind");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Three of a Kind");
    }
    public static ItemStack fourOfAKind(GamePlayer p) {
        if(Validating.fourOfAKind(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four of a Kind");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Four of a Kind");
    }
    public static ItemStack fullHouse(GamePlayer p) {
        if(Validating.fullHouse(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Full House");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Full House");
    }

    public static ItemStack smallStreet(GamePlayer p) {
        if(Validating.smallStraight(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Small Straight");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Small Straight");
    }
    public static ItemStack bigStreet(GamePlayer p) {
        if(Validating.bigStraight(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Big Straight");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Big Straight");
    }
    public static ItemStack yatzy(GamePlayer p) {
        if(Validating.yatzy(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Yatzy");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Yatzy");
    }
    public static ItemStack chance(GamePlayer p) {
        if(Validating.chance(p)) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Chance");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Chance");
    }

    public static ItemStack roll(Game game) {
        if(game.getCurrentTurn() >= 3) {
            return itemWithName(Material.RED_CONCRETE, 1, ChatColor.RED + "You have ran out of turns!", "ROLL");
        }
        return itemWithName(Material.MAGENTA_GLAZED_TERRACOTTA, 1, ChatColor.DARK_GREEN + "Roll!", "ROLL");
    }
    public static ItemStack pane = itemWithName(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.RESET + "", "PANE");


    public static ItemStack diceItem(Dice dice) {
        if(dice.isHeld()) {
            return itemWithName(Material.GREEN_CONCRETE, dice.getNumber(), ChatColor.DARK_GREEN + "" + ChatColor.BOLD + dice.getNumber(), "DICE");
        }
        switch(dice.getNumber()) {
            case 0:
                return itemWithName(Material.GRAY_CONCRETE, 1, ChatColor.RESET + "", "DICE");
            case 1:
                return itemWithName(Material.RED_CONCRETE, 1, ChatColor.RED + "1", "DICE");
            case 2:
                return itemWithName(Material.ORANGE_CONCRETE, 2, ChatColor.GOLD + "2", "DICE");
            case 3:
                return itemWithName(Material.YELLOW_CONCRETE, 3, ChatColor.YELLOW + "3", "DICE");
            case 4:
                return itemWithName(Material.BLUE_CONCRETE, 4, ChatColor.DARK_BLUE + "4", "DICE");
            case 5:
                return itemWithName(Material.CYAN_CONCRETE, 5, ChatColor.DARK_AQUA + "5", "DICE");
            case 6:
                return itemWithName(Material.LIGHT_BLUE_CONCRETE, 6, ChatColor.BLUE + "6", "DICE");
        }
        return itemWithName(Material.WHITE_CONCRETE, dice.getNumber(), String.valueOf(dice.getNumber()), "DICE");
    }

    public static ItemStack statsItem(GamePlayer p) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(p.getPlayer().getUniqueId()));
        meta.setDisplayName(ChatColor.GRAY + "Points: " + ChatColor.DARK_GREEN + p.getTotalScore());
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack itemWithName(Material m, int amount, String name, String id) {
        ItemStack item = new ItemStack(m, amount);
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack itemWithName(Material m, int amount, String name) {
        ItemStack item = new ItemStack(m, amount);
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, ChatColor.stripColor(name.toUpperCase().replaceAll(" ", "_")));
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}
