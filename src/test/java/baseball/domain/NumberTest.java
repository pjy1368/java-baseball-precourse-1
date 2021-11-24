package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Number 테스트")
public class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234", "-12", "103", "abc"})
    @DisplayName("숫자가 0을 포함하지 않는 3자리 자연수인지 확인한다.")
    void create(String value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0을 포함하지 않는 3자리 자연수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112"})
    @DisplayName("숫자가 중복되지 않는지 확인한다.")
    void create_distinct(String value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 수여야 합니다.");
    }
}
