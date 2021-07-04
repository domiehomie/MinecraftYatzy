package live.mufin.yatzy.datatypes;

import live.mufin.yatzy.enums.DiceOption;

public class Dice {
    int number;
    boolean isHeld;

    public Dice(DiceOption number, boolean isHeld) {
        this.number = number.number;
        this.isHeld = isHeld;
    }

    public Dice(int number, boolean isHeld) {
        this.number = number;
        this.isHeld = isHeld;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setHeld(boolean held) {
        this.isHeld = held;
    }

    public int getNumber() {
        return number;
    }

    public boolean isHeld() {
        return isHeld;
    }
}
