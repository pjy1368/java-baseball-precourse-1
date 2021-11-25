package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Number {

    private static final int NUMBER_LENGTH = 3;
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]+$";

    private final int value;

    public Number(String value) {
        validateNumber(value);
        this.value = Integer.parseInt(value);
    }

    public Number(List<Integer> values) {
        this(values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

    private void validateNumber(String value) {
        if (!value.matches(NATURAL_NUMBER_REGEX) || value.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("0을 포함하지 않는 3자리 자연수여야 합니다.");
        }

        if (!isDistinctNumber(value)) {
            throw new IllegalArgumentException("서로 다른 수여야 합니다.");
        }
    }

    private boolean isDistinctNumber(String value) {
        long distinctNumberCount = value.chars()
                .mapToObj(i -> (char) i)
                .distinct()
                .count();

        return distinctNumberCount == NUMBER_LENGTH;
    }
}
