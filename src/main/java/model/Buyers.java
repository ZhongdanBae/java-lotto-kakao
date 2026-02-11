package model;

import java.util.Map;

public class Buyers {
    private Lottos lottos;
    private Integer spentMoney = 0;
    private LottoResult lottoResult;
    private Result result;
    private Double profitRate = 0.0;
    private final Vendor vendor;

    public Buyers(){
        lottoResult = new LottoResult();
        lottos = new Lottos();
        vendor = new Vendor();
    }

    public Lottos buyLotto(Integer money) {
        Money purchaseMoney = new Money(money);
        Lottos returnedLottos = vendor.sell(purchaseMoney);
        setLottos(returnedLottos);
        addSpentMoney(purchaseMoney);
        return lottos;
    }

    public void setLottos(Lottos lottos) {
        this.lottos = lottos;
    }

    public void addSpentMoney(Integer money){
        addSpentMoney(new Money(money));
    }

    public void addSpentMoney(Money money){
        this.spentMoney += money.getValue();
    }

    public void setResult(Result result){
        this.result = result;
    }

    public Map<LottoRank, Integer> compare(){
        lottoResult = new LottoResult();
        if(result == null || spentMoney == 0){
            profitRate = 0.0;
            return lottoResult.getResultCount();
        }
        for(Lotto lotto : lottos.getLottoList()) lottoResult.add(calculateRank(lotto));
        profitRate = (double) lottoResult.calculateTotalPrize() / spentMoney;
        return lottoResult.getResultCount();
    }

    public Double getProfitRate(){
        return profitRate;
    }

    private LottoRank calculateRank(Lotto lotto){
        int matchCount = calculateMatchCount(lotto);
        boolean matchBonus = lotto.getNumbers().contains(result.getBonus());
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private int calculateMatchCount(Lotto lotto){
        int matchCount = 0;
        for(Integer number : lotto.getNumbers()) matchCount += result.getNumbers().contains(number) ? 1 : 0;
        return matchCount;
    }
}
