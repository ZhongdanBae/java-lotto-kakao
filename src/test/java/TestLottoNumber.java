import model.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestLottoNumber {

    @Test
    void 로또번호_값객체는_1부터_45사이_숫자만_허용한다() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호는 1~45까지의 숫자여야 한다.");
    }

    @Test
    void 로또번호_값객체는_동등성_비교가_가능하다() {
        LottoNumber first = new LottoNumber(3);
        LottoNumber second = new LottoNumber(3);

        assertThat(first).isEqualTo(second);
    }
}
