package live.mufin.yatzy.enums;

public enum ScoreOption {
    ONES(-1),
    TWOS(-1),
    THREES(-1),
    FOURS(-1),
    FIVES(-1),
    SIXES(-1),
    THREE_OF_A_KIND(-1),
    FOUR_OF_A_KIND(-1),
    FULL_HOUSE(25),
    SMALL_STRAIGHT(30),
    LARGE_STRAIGHT(40),
    YATZY(50),
    CHANCE(-1);

    public int value;
    ScoreOption(int type) {
    this.value = type;
    }
}
