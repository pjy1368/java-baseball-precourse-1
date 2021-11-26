package baseball.domain;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(int value) {
        validateNaturalNumber(value);
        this.value = value;
    }

    public Number(String value) {
        validateDigit(value);
        this.value = Integer.parseInt(value);
    }

    private void validateNaturalNumber(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("숫자에 0이 있으면 안됩니다.");
        }
    }

    private void validateDigit(String value) {
        if (!Character.isDigit(value.charAt(0))) {
            throw new IllegalArgumentException("숫자에 문자 값이 있으면 안됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
