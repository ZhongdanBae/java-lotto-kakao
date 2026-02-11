package model;

public class Money {
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int MIN_PURCHASE_MONEY = 1;

    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_PURCHASE_MONEY) {
            throw new RuntimeException("금액은 0보다 커야 합니다");
        }
        if (value % LOTTO_PRICE_UNIT != 0) {
            throw new RuntimeException("천원 단위의 금액을 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }

    public int toLottoCount() {
        return value / LOTTO_PRICE_UNIT;
    }
}
