package live.mufin.yatzy.datatypes;

import live.mufin.yatzy.enums.ScoreOption;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class GamePlayer {

    Player player;
    LinkedList<Dice> die;
    HashMap<ScoreOption, Integer> scores;
    int totalScore;

    public GamePlayer(Player player, LinkedList<Dice> die, HashMap<ScoreOption, Integer> scores, int totalScore) {
        this.player = player;
        this.die = die;
        this.scores = scores;
        this.totalScore = totalScore;
    }

    public LinkedList<Dice> getDie() {
        return die;
    }

    public HashMap<ScoreOption, Integer> getScores() {
        return scores;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
