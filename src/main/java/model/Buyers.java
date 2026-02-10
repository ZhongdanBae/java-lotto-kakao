package model;

import java.util.Map;

public class Buyers {
    Lottos lottos;
    Integer spentMoney = 0;
    LottoResult lottoResult;
    Result result;
    Double profitRate = 0.0;
    Vendor vendor;

    public Buyers(){
        lottoResult = new LottoResult();
        lottos = new Lottos();
        vendor = new Vendor();
    }

    public Lottos buyLotto(Integer money) {
        Lottos returnedLottos = vendor.sell(money);
        setLottos(returnedLottos);
        setSpentMoney(money);
        return lottos;
    }

    public void setLottos(Lottos lottos) {
        this.lottos = lottos;
    }

    public void setSpentMoney(Integer money){
        this.spentMoney += money;
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
