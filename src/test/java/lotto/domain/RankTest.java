package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankTest {
    @CsvSource({"6, true",
            "6, false"})
    @ParameterizedTest
    void firstCase(int countOfMatch, boolean containsBonus) {
        assertThat(Rank.calculateRank(countOfMatch, containsBonus)).isEqualTo(Rank.FIRST);
    }

    @CsvSource({"5, true"})
    @ParameterizedTest
    void secondCase(int countOfMatch, boolean containsBonus) {
        assertThat(Rank.calculateRank(countOfMatch, containsBonus)).isEqualTo(Rank.SECOND);
    }

    @CsvSource({"5, false"})
    @ParameterizedTest
    void thirdCase(int countOfMatch, boolean containsBonus) {
        assertThat(Rank.calculateRank(countOfMatch, containsBonus)).isEqualTo(Rank.THIRD);
    }

    @CsvSource({"4, true",
            "4, false"})
    @ParameterizedTest
    void fourthCase(int countOfMatch, boolean containsBonus) {
        assertThat(Rank.calculateRank(countOfMatch, containsBonus)).isEqualTo(Rank.FOURTH);
    }

    @CsvSource({"3, true",
            "3, false"})
    @ParameterizedTest
    void fifthCase(int countOfMatch, boolean containsBonus) {
        assertThat(Rank.calculateRank(countOfMatch, containsBonus)).isEqualTo(Rank.FIFTH);
    }

    @CsvSource({"2, true",
            "2, false",
            "1, true",
            "1, false",
            "0, true",
            "0, false"})
    @ParameterizedTest
    void missCase(int countOfMatch, boolean containsBonus) {
        assertThat(Rank.calculateRank(countOfMatch, containsBonus)).isEqualTo(Rank.MISS);
    }
}