package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

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
}
