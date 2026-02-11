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
        printWinningStatistics();
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

    private void printWinningStatistics(){
        if(profitRate == 0.0) throw new RuntimeException("총 수익률은 0이 될 수 없습니다.");
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + LottoRank.FIFTH.getPrize() + "원)- " + lottoResult.getCount(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (" + LottoRank.FOURTH.getPrize() + "원)- " + lottoResult.getCount(LottoRank.FOURTH) + "개");
        System.out.println("5개 일치 (" + LottoRank.THIRD.getPrize() + "원)- " + lottoResult.getCount(LottoRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + LottoRank.SECOND.getPrize() + "원) - " + lottoResult.getCount(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (" + LottoRank.FIRST.getPrize() + "원)- " + lottoResult.getCount(LottoRank.FIRST) + "개");
        if(profitRate > 1) {
            System.out.printf("총 수익률은 %.2f입니다. 이득보셨습니다! 로또 짱짱%n", profitRate);
            return;
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitRate);
    }

}
