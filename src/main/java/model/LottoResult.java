package model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultCount;

    public LottoResult() {
        this.resultCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            resultCount.put(rank, 0);
        }
    }

    public void add(LottoRank rank) {
        if (rank == null) return;
        resultCount.put(rank, resultCount.get(rank) + 1);
    }

    public Integer getCount(LottoRank rank) {
        return resultCount.getOrDefault(rank, 0);
    }

    public Long calculateTotalPrize() {
        Long total = 0L;
        for (Map.Entry<LottoRank, Integer> entry : resultCount.entrySet()) {
            total += entry.getKey().getPrize() * entry.getValue();
        }
        return total;
    }

    public Map<LottoRank, Integer> getResultCount() {
        return Collections.unmodifiableMap(resultCount);
    }
}
