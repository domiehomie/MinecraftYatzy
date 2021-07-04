package live.mufin.yatzy.datatypes;

import live.mufin.yatzy.enums.ScoreOption;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class GamePlayer {

    Game game;
    Player player;
    LinkedList<Dice> die;
    HashMap<ScoreOption, Integer> scores;
    int totalScore;

    public GamePlayer(Player player, LinkedList<Dice> die, int totalScore) {
        this.player = player;
        this.die = die;
        this.scores = new HashMap<>();
        this.totalScore = totalScore;
    }

    public void setTotalScore(int score) {
        this.totalScore = score;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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
