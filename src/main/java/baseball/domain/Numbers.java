package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final int NUMBER_LENGTH = 3;

    private final List<Number> numberGroup;

    public Numbers(List<Integer> numberGroup) {
        validateNumber(numberGroup);
        this.numberGroup = numberGroup.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void validateNumber(List<Integer> values) {
        if (!isDistinctNumber(values) || values.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("서로 다른 3자리 자연수여야 합니다.");
        }
    }

    private boolean isDistinctNumber(List<Integer> values) {
        long distinctNumberCount = values.stream()
                .distinct()
                .count();
        return distinctNumberCount == NUMBER_LENGTH;
    }

    public GameScore score(Numbers opponentNumbers) {
        int ballNumber = 0;
        int strikeNumber = 0;

        for (int i = 0; i < this.numberGroup.size(); i++) {
            Number number = this.numberGroup.get(i);

            if (isStrike(number, i, opponentNumbers)) {
                strikeNumber++;
                continue;
            }
            if (isBall(number, opponentNumbers)) {
                ballNumber++;
            }
        }
        return new GameScore(ballNumber, strikeNumber);
    }

    private boolean isStrike(Number number, int position, Numbers opponentNumbers) {
        for (int i = 0; i < opponentNumbers.numberGroup.size(); i++) {
            if (number.equals(opponentNumbers.numberGroup.get(i)) && position == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isBall(Number number, Numbers opponentNumbers) {
        return opponentNumbers.numberGroup.contains(number);
    }
}
