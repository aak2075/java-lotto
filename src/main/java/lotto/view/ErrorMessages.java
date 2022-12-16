package lotto.view;

public enum ErrorMessages {
    INPUT_NUMBER_ERROR("[ERROR] 구매 금액은 숫자만 가능합니다."),
    INPUT_WINNING_NUMBERS_ERROR("[ERROR] 당첨 번호는 숫자만 입력 가능합니다."),
    INPUT_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
