package live.mufin.yatzy.enums;

public enum ScoreOption {
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    THREE_OF_A_KIND(7),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(9),
    SMALL_STREET(10),
    LARGE_STREET(11),
    YATZY(12),
    CHANCE(13);

    public int type;
    ScoreOption(int type) {
    this.type = type;
    }
}
