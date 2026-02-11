package model;

public class Vendor {

    private final AutoLottoGenerator autoLottoGenerator;

    public Vendor(){
        autoLottoGenerator = new AutoLottoGenerator();
    }

    public Lottos sell(int money){
        if (money%1000 > 0) throw new RuntimeException("천원 단위의 금액을 입력해주세요.");
        if (money <= 0) throw new RuntimeException("금액은 0보다 커야 합니다");


        Lottos lottos = new Lottos();

        for(int i = 0; i < money/1000; i++){
            lottos.add(autoLottoGenerator.issueLotto());
        }

        return lottos;
    }
}
