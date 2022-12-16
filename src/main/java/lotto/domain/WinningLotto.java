package lotto.domain;

import lotto.Lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto other) {
        return lotto.matchCount(other);
    }

    public boolean contains(Lotto other) {
        return other.contains(bonusNumber);
    }
}
