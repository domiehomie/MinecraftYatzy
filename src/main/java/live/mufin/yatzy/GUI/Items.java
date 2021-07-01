package live.mufin.yatzy.GUI;

import live.mufin.yatzy.Yatzy;
import live.mufin.yatzy.datatypes.Dice;
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
import java.util.Collections;
import java.util.List;

public class Items {

    public static NamespacedKey key = new NamespacedKey(Yatzy.getInstance(), "id");

    public static ItemStack ones(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 1) {
                return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Ones");
            }
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Ones");
    }
    public static ItemStack twos(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 2) {
                return itemWithName(Material.GREEN_STAINED_GLASS, 2, ChatColor.GRAY + "Twos");
            }
        }
        return itemWithName(Material.TINTED_GLASS, 2, ChatColor.GRAY + "Twos");
    }
    public static ItemStack threes(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 3) {
                return itemWithName(Material.GREEN_STAINED_GLASS, 3, ChatColor.GRAY + "Threes");
            }
        }
        return itemWithName(Material.TINTED_GLASS, 3, ChatColor.GRAY + "Threes");
    }
    public static ItemStack fours(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 4) {
                return itemWithName(Material.GREEN_STAINED_GLASS, 4, ChatColor.GRAY + "Fours");
            }
        }
        return itemWithName(Material.TINTED_GLASS, 4, ChatColor.GRAY + "Fours");
    }
    public static ItemStack fives(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 5) {
                return itemWithName(Material.GREEN_STAINED_GLASS, 5, ChatColor.GRAY + "Fives");
            }
        }
        return itemWithName(Material.TINTED_GLASS, 5, ChatColor.GRAY + "Fives");
    }
    public static ItemStack sixes(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 6) {
                return itemWithName(Material.GREEN_STAINED_GLASS, 6, ChatColor.GRAY + "Sixes");
            }
        }
        return itemWithName(Material.TINTED_GLASS, 6, ChatColor.GRAY + "Sixes");
    }
    public static ItemStack threeOfAKind(GamePlayer p) {
        ArrayList<Integer> diceScores = new ArrayList<Integer>();
        p.getDie().forEach(dice -> diceScores.add(dice.getNumber()));
        if(Collections.frequency(diceScores, 1) >= 3) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
        }if(Collections.frequency(diceScores, 2) >= 3) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
        }if(Collections.frequency(diceScores, 3) >= 3) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
        }if(Collections.frequency(diceScores, 4) >= 3) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
        }if(Collections.frequency(diceScores, 5) >= 3) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
        }if(Collections.frequency(diceScores, 6) >= 3) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
        }

        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Three Of A Kind");
    }
    public static ItemStack fourOfAKind(GamePlayer p) {
        ArrayList<Integer> diceScores = new ArrayList<Integer>();
        p.getDie().forEach(dice -> diceScores.add(dice.getNumber()));
        if(Collections.frequency(diceScores, 1) >= 4) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
        }if(Collections.frequency(diceScores, 2) >= 4) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
        }if(Collections.frequency(diceScores, 3) >= 4) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
        }if(Collections.frequency(diceScores, 4) >= 4) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
        }if(Collections.frequency(diceScores, 5) >= 4) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
        }if(Collections.frequency(diceScores, 6) >= 4) {
            return itemWithName(Material.GREEN_STAINED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
        }
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Four Of A Kind");
    }
    public static ItemStack fullHouse(GamePlayer p) {
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Full House");
    }

    public static ItemStack smallStreet(GamePlayer p) {
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Small Street");
    }
    public static ItemStack bigStreet(GamePlayer p) {
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Big Street");
    }
    public static ItemStack yatzy(GamePlayer p) {
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Yatzy");
    }
    public static ItemStack chance(GamePlayer p) {
        return itemWithName(Material.TINTED_GLASS, 1, ChatColor.GRAY + "Chance");
    }

    public static ItemStack roll = itemWithName(Material.MAGENTA_GLAZED_TERRACOTTA, 1, ChatColor.DARK_GREEN + "Roll!", "ROLL");
    public static ItemStack pane = itemWithName(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.RESET + "", "PANE");


    public static ItemStack diceItem(Dice dice) {
        if(dice.getNumber() == 0) {
            return itemWithName(Material.GRAY_CONCRETE, 1, ChatColor.RESET + "", "DICE");
        }
        if(dice.isHeld()) {
            return itemWithName(Material.GREEN_CONCRETE, dice.getNumber(), String.valueOf(dice.getNumber()), "DICE");
        } else {
            return itemWithName(Material.WHITE_CONCRETE, dice.getNumber(), String.valueOf(dice.getNumber()), "DICE");
        }
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
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, name.toUpperCase().replaceAll(" ", "_"));
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}
