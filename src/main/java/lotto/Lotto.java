package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int matchCount(Lotto other) {
       return (int) numbers.stream()
               .filter(other::contains)
               .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
