import model.AutoLottoGenerator;
import model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestLotto {

    @Test
    void 로또_번호는_6개의_수로_이루어져야_한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호가_6개의_수가_아닐때_에러를_Throw() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        try {
            Lotto lotto = new Lotto(numbers);
            fail();
        }
        catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("로또 번호 개수가 6개가 아닙니다.");
        }
    }

    @Test
    void 로또_번호는_모두_달라야_한다() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5);

        try {
            Lotto lotto = new Lotto(numbers);
            fail();
        }
        catch (RuntimeException e){
            assertThat(e.getMessage()).isEqualTo("로또 번호는 중복될 수 없습니다");
        }
    }

    @Test
    void 로또_번호는_모두_1에서_45까지() {
        List<Integer> numbers = List.of(1, 2, 3, 0, 4, 5);
        try {
            Lotto lotto = new Lotto(numbers);
            fail();
        }
        catch (RuntimeException e){
            assertThat(e.getMessage()).isEqualTo("로또 번호는 1~45까지의 숫자여야 한다.");
        }
    }
}
