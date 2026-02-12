import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import model.Lotto;
import org.junit.jupiter.api.Test;
import model.AutoLottoGenerator;

public class TestAutoLottoGenerator {
	@Test
	void 자동으로_생성된_로또번호는_6자리이다() {
		AutoLottoGenerator generator = new AutoLottoGenerator();
		assertThat(generator.issueLotto().size()).isEqualTo(6);
	}

	@Test
	void 자동으로_생성된_로또번호는_6개의_수를_가져야_한다() {
		AutoLottoGenerator generator = new AutoLottoGenerator();
		Lotto lotto = generator.issueLotto();
		assertThat(lotto.getNumbers().size()).isEqualTo(6);
	}

	@Test
	void 자동으로_생성된_로또번호는_1에서_45_사이의_자연수이다() {
		AutoLottoGenerator generator = new AutoLottoGenerator();
		Lotto lotto = generator.issueLotto();
		boolean allInRange = lotto.getNumbers().stream().allMatch(number -> 1 <= number && number <= 45);
		assertThat(allInRange).isTrue();
	}

	@Test
	void 자동으로_생성된_로또번호는_중복되는_수가_없어야_한다() {
		AutoLottoGenerator generator = new AutoLottoGenerator();
		Lotto lotto = generator.issueLotto();
		long distinctCount = lotto.getNumbers().stream().distinct().count();
		assertThat(distinctCount).isEqualTo(lotto.getNumbers().size());
	}
}
