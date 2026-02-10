package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottoList;

    public Lottos(){
        lottoList = new ArrayList<>();
    }

    public Integer getQuantity(){
        return lottoList.size();
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public void add(Lotto lotto){
        lottoList.add(lotto);
    }

    static public void printLottoTickets(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            // Lotto 객체 내부에 번호를 반환하는 메서드(예: getNumbers())가 있다고 가정
            System.out.println(lotto.getNumbers());
        }
    }
}
