package live.mufin.yatzy.datatypes;

import java.util.Arrays;
import java.util.UUID;

public class Game {
    UUID id;
    GamePlayer[] players;

    public GamePlayer[] getPlayers() {
        return players;
    }

    public UUID getId() {
        return id;
    }

    public Game(GamePlayer[] players, UUID id) {
        this.players = players;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", players=" + Arrays.toString(players) +
                '}';
    }
}
