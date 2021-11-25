package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Computer 테스트")
public class ComputerTest {

    private Computer computer = new Computer();

    @Test
    @DisplayName("숫자가 잘 생성되는지 확인한다.")
    void generateNumber() {
        assertThatCode(() -> computer.generateNumber())
                .doesNotThrowAnyException();
    }
}
