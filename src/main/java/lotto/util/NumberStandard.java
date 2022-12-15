package lotto.util;

public enum NumberStandard {
    MIN(1),
    MAX(45),
    LENGTH(6);

    private final int value;

    NumberStandard(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
