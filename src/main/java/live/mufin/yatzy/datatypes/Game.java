package live.mufin.yatzy.datatypes;

import java.util.Arrays;
import java.util.UUID;

public class Game {
    UUID id;
    GamePlayer[] players;
    int currentPlayer;
    int currentTurn;

    public GamePlayer[] getPlayers() {
        return players;
    }

    public UUID getId() {
        return id;
    }

    public Game(GamePlayer[] players, UUID id) {
        this.players = players;
        this.id = id;
        this.currentPlayer = 0;
        this.currentTurn = 0;

        for (GamePlayer player : players) {
            player.setGame(this);
        }
    }

    public void nextPlayer() {
        try {
            currentPlayer++;
            GamePlayer p = players[currentPlayer];
        } catch(IndexOutOfBoundsException e) {
            currentPlayer = 0;
        }
    }

    public void nextTurn() {
        if(currentTurn >= 3)
            currentTurn = 0;
        else currentTurn++;
    }

    public void resetTurn() {
        currentTurn = 0;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public GamePlayer getCurrentPlayer() {
        return players[currentPlayer];
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", players=" + Arrays.toString(players) +
                '}';
    }
}
