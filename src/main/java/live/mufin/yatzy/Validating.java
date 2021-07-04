package live.mufin.yatzy;

import live.mufin.yatzy.datatypes.Dice;
import live.mufin.yatzy.datatypes.GamePlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Validating {

    public static boolean ones(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 1) {
                return true;
            }
        }
        return false;
    }
    public static boolean twos(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 2) {
                return true;
            }
        }
        return false;
    }
    public static boolean threes(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 3) {
                return true;
            }
        }
        return false;
    }
    public static boolean fours(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 4) {
                return true;
            }
        }
        return false;
    }
    public static boolean fives(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 5) {
                return true;
            }
        }
        return false;
    }
    public static boolean sixes(GamePlayer p) {
        for(Dice dice : p.getDie()) {
            if(dice.getNumber() == 6) {
                return true;
            }
        }
        return false;
    }

    public static boolean threeOfAKind(GamePlayer p) {
        return multitude(3, p);
    }
    public static boolean fourOfAKind(GamePlayer p) {
        return multitude(4, p);
    }
    public static boolean fullHouse(GamePlayer p) {
        boolean canPlay = false;
        boolean isYatzy = false;
        List<Integer> die = new ArrayList<>();
        p.getDie().forEach(dice -> die.add(dice.getNumber()));
        if(!die.contains(0)) {
            int[] counts = new int[6];
            for (Integer integer : die) counts[integer - 1]++;
            boolean check2 = false;
            boolean check3 = false;
            for (int i : counts) {
                check2 |= (i == 2); //found 2 of some number
                check3 |= (i == 3); //found 3 of some number
                if (i == 5) return true; //found a Yahtzee so stop and return true
            }
            return (check2 && check3);
        }
        return false;
    }
    public static boolean smallStraight(GamePlayer p) {
        System.out.println("SMALL========");
        return straight(4, p);
    }
    public static boolean bigStraight(GamePlayer p) {
        System.out.println("BIG========");
        return straight(5, p);
    }
    public static boolean yatzy(GamePlayer p) {
        return multitude(5, p);
    }
    public static boolean chance(GamePlayer p) {
        List<Integer> ints = new ArrayList<>();
        p.getDie().forEach(dice -> ints.add(dice.getNumber()));
        return (!ints.contains(0));
    }


    private static boolean straight(int size, GamePlayer p) {
        List<Integer> dices = new ArrayList<>();
        p.getDie().forEach(dice -> dices.add(dice.getNumber()));
        int counter = 1;
        boolean found = false;
        Integer[] die = dices.toArray(new Integer[dices.size()]);
        Arrays.sort(die);

        for (int i = 0; i < die.length - 1; i++)
        {
            if (counter == size)
                return true;

            if (die[i + 1] == die[i] + 1)
            {
                counter++;
            }
            else {
                counter = 0;
            }
        }
        return false;
    }
    private static boolean multitude(int amt, GamePlayer p) {
        ArrayList<Integer> diceScores = new ArrayList<>();
        p.getDie().forEach(dice -> diceScores.add(dice.getNumber()));
        if(Collections.frequency(diceScores, 1) >= amt) {
            return true;
        }if(Collections.frequency(diceScores, 2) >= amt) {
            return true;
        }if(Collections.frequency(diceScores, 3) >= amt) {
            return true;
        }if(Collections.frequency(diceScores, 4) >= amt) {
            return true;
        }if(Collections.frequency(diceScores, 5) >= amt) {
            return true;
        }if(Collections.frequency(diceScores, 6) >= amt) {
            return true;
        }
        return false;
    }

}
