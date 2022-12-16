package lotto.view;

import lotto.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void inputAmount() {
        System.out.println(Messages.INPUT_AMOUNT.getMessage());
    }

    public static void numberOfLotto(int number) {
        System.out.println(number + Messages.NUMBER_OF_LOTTO.getMessage());
    }

    public static void lottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void inputWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS.getMessage());
    }

    public static void inputBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER.getMessage());
    }

    public static void statistics(Map<Rank, Integer> result) {
        System.out.println(Messages.STATISTICS.getMessage());
        DecimalFormat format = new DecimalFormat("###,###");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> System.out.printf(
                        Messages.getWinningInfo(rank),
                        rank.getCountOfMatch(),
                        format.format(rank.getWinningMoney()),
                        result.get(rank))
                );
    }

    public static void profitRate(double profitRate) {
        System.out.printf(Messages.PROFIT_RATE.getMessage(), profitRate);
    }
}
