package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    public static void inputAmount() {
        System.out.println(Messages.INPUT_AMOUNT);
    }

    public static void numberOfLotto(int number) {
        System.out.println(number + Messages.NUMBER_OF_LOTTO.toString());
    }

    public static void lottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void inputWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS);
    }

    public static void inputBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER);
    }


}
