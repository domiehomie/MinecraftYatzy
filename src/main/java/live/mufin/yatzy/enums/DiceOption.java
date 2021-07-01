package live.mufin.yatzy.enums;

public enum DiceOption {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    public int number;
    DiceOption(int number) {
        this.number=number;
    }
}
