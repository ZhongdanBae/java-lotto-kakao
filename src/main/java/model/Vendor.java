package model;

public class Vendor {
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
}
