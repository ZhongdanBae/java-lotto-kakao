package model;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final Integer value;

    public LottoNumber(Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        if (value == null) {
            throw new RuntimeException("로또 번호는 1~45까지의 숫자여야 한다.");
        }
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new RuntimeException("로또 번호는 1~45까지의 숫자여야 한다.");
        }
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
