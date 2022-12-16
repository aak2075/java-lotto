package lotto.view;

import lotto.domain.Rank;

public enum Messages {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTO("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n" +
            "---"),
    WIN_INFO("%d개 일치 (%s)원 - %d개\n"),
    WIN_INFO_BONUS_CONTAINED("%d개 일치, 보너스 볼 일치 (%s)원 - %d개\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getWinningInfo(Rank rank) {
        if (rank == Rank.SECOND) {
            return Messages.WIN_INFO_BONUS_CONTAINED.getMessage();
        }
        return Messages.WIN_INFO.getMessage();
    }
}
