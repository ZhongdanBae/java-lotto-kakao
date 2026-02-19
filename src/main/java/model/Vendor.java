package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vendor {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final AutoLottoGenerator autoLottoGenerator;

    public Vendor(){
        autoLottoGenerator = new AutoLottoGenerator();
    }

    public Lottos sell(int money){
        return sell(new Money(money));
    }

    public Lottos sell(Money money){
        Lottos lottos = new Lottos();

        for(int i = 0; i < money.toLottoCount(); i++){
            lottos.add(autoLottoGenerator.issueLotto());
        }

        return lottos;
    }

    public Lottos sell(Money money, Integer manualLottoCount, List<String> manualLottoInputs) {
        validateManualLottoCount(manualLottoCount, money.toLottoCount());
        validateManualInputCount(manualLottoInputs, manualLottoCount);

        Lottos lottos = new Lottos();

        for (String manualLottoInput : manualLottoInputs) {
            lottos.add(new Lotto(parseManualLottoNumbers(manualLottoInput)));
        }

        int autoLottoCount = money.toLottoCount() - manualLottoCount;
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(autoLottoGenerator.issueLotto());
        }

        return lottos;
    }

    private void validateManualLottoCount(Integer manualLottoCount, Integer totalLottoCount) {
        if (manualLottoCount == null) {
            throw new RuntimeException("수동 구매 수는 비어 있을 수 없습니다.");
        }
        if (manualLottoCount < 0) {
            throw new RuntimeException("수동 구매 수는 0 이상이어야 합니다.");
        }
        if (manualLottoCount > totalLottoCount) {
            throw new RuntimeException("수동 로또 수는 전체 구매 수를 초과할 수 없습니다.");
        }
    }

    private void validateManualInputCount(List<String> manualLottoInputs, Integer manualLottoCount) {
        if (manualLottoInputs == null) {
            throw new RuntimeException("수동 로또 번호 입력이 필요합니다.");
        }
        if (manualLottoInputs.size() != manualLottoCount) {
            throw new RuntimeException("수동 로또 번호 입력 개수가 수동 구매 수와 다릅니다.");
        }
    }

    private List<Integer> parseManualLottoNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (numbers.size() != LOTTO_NUMBER_COUNT) {
                throw new RuntimeException("수동 로또 번호는 6개의 숫자여야 합니다.");
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new RuntimeException("수동 로또 번호는 숫자여야 합니다.");
        }
    }
}
