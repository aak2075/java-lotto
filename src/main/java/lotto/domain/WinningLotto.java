package lotto.domain;

import lotto.Lotto;
import lotto.util.NumberStandard;
import lotto.view.ErrorMessages;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto other) {
        return lotto.matchCount(other);
    }

    public boolean contains(Lotto other) {
        return other.contains(bonusNumber);
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < NumberStandard.MIN.getValue() || bonusNumber > NumberStandard.MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_RANGE_ERROR.getMessage());
        }
    }
}
