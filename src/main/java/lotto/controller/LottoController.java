package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    LottoMachine machine;
    public void run() {
        init();
        try {
            int amount = amount();
            List<Lotto> lottos = buy(amount);
            WinningLotto winningLotto = setWinning();
            result(lottos, winningLotto, amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void init() {
        NumberGenerator generator = new RandomNumberGenerator();
        machine = new LottoMachine(generator);
    }

    private int amount() {
        OutputView.inputAmount();
        return InputView.readAmount();
    }

    public List<Lotto> buy(int amount) {
        List<Lotto> lottos = machine.buy(amount);
        OutputView.numberOfLotto(lottos.size());
        OutputView.lottoNumbers(lottos);

        return lottos;
    }

    public WinningLotto setWinning() {
        OutputView.inputWinningNumbers();
        Lotto lotto = new Lotto(InputView.readWinningNumber());
        OutputView.inputBonusNumber();
        return new WinningLotto(lotto, InputView.readBonusNumber());
    }

    public void result(List<Lotto> lottos, WinningLotto winningLotto, int amount) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            result.addResult(lotto, winningLotto);
        }
        OutputView.statistics(result.getResult());
        OutputView.profitRate(result.calProfitRate(amount));
    }
}
