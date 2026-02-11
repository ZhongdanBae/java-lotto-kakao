package model;

public class Vendor {
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int MIN_PURCHASE_MONEY = 1;

    private final AutoLottoGenerator autoLottoGenerator;

    public Vendor(){
        autoLottoGenerator = new AutoLottoGenerator();
    }

    public Lottos sell(int money){
        if (money % LOTTO_PRICE_UNIT > 0) throw new RuntimeException("천원 단위의 금액을 입력해주세요.");
        if (money < MIN_PURCHASE_MONEY) throw new RuntimeException("금액은 0보다 커야 합니다");


        Lottos lottos = new Lottos();

        for(int i = 0; i < money / LOTTO_PRICE_UNIT; i++){
            lottos.add(autoLottoGenerator.issueLotto());
        }

        return lottos;
    }
}
