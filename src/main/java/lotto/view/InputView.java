package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int readAmount() {
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    public static List<Integer> readWinningNumber() {
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_WINNING_NUMBERS_ERROR.getMessage());
        }
        return numbers;
    }

    public static int readBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_ERROR.getMessage());
        }
    }
}
