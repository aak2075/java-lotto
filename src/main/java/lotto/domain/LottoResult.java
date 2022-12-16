package lotto.domain;

import lotto.Lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void addResult(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.matchCount(lotto);
        boolean containsBonus = winningLotto.contains(lotto);
        Rank rank = Rank.calculateRank(matchCount, containsBonus);
        result.put(rank, result.get(rank) + 1);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public double calProfitRate(int amount) {
        return calProfit() / (double) amount * 100;
    }

    private int calProfit() {
        return result.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .mapToInt(Rank::getWinningMoney)
                .sum();
    }
}
