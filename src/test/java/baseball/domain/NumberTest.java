package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Number 테스트")
public class NumberTest {

    @Test
    @DisplayName("숫자에 문자는 들어갈 수 없다.")
    void create_char() {
        assertThatThrownBy(() -> new Number("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자에 문자 값이 있으면 안됩니다.");
    }

    @Test
    @DisplayName("숫자에 0은 들어갈 수 없다.")
    void create_zero() {
        assertThatThrownBy(() -> new Number(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자에 0이 있으면 안됩니다.");
    }
}
