package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                NumberStandard.MIN.getValue(),
                NumberStandard.MAX.getValue(),
                NumberStandard.LENGTH.getValue()
        );
    }
}
