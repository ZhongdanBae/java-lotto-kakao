import model.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMoney {

    @Test
    void 금액은_0보다_커야한다() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("금액은 0보다 커야 합니다");
    }

    @Test
    void 금액은_천원_단위여야한다() {
        assertThatThrownBy(() -> new Money(1300))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("천원 단위의 금액을 입력해주세요.");
    }

    @Test
    void 금액으로_구매할_로또_개수를_계산한다() {
        Money money = new Money(12000);
        assertThat(money.toLottoCount()).isEqualTo(12);
    }
}
