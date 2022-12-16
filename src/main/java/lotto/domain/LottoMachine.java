package lotto.domain;

import lotto.Lotto;
import lotto.util.NumberGenerator;
import lotto.view.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final NumberGenerator generator;

    public LottoMachine(NumberGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> buy(int amount) {
        validate(amount);
        List<Lotto> lottos = new ArrayList<>();
        int count = numberOfLotto(amount);
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generator.generate());
            lottos.add(lotto);
        }
        return lottos;
    }

    private int numberOfLotto(int amount) {
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_AMOUNT_ERROR.getMessage());
        }
    }
}
