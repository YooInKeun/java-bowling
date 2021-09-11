package bowling.model.frame;

import java.util.Objects;

public class Score {
    private static final int MIN = 0;
    private static final int MAX = 300;

    private int score;

    private Score(int score) {
        validateRange(score);

        this.score = score;
    }

    public static Score of(int score) {
        return new Score(score);
    }

    private void validateRange(int score) {
        if (score < MIN || score > MAX) {
            throw new IllegalArgumentException(String.format("볼링 점수는 %d점 이상 %d점 이하이어야 합니다.", MIN, MAX));
        }
    }

    public Score plus(int other) {
        return Score.of(score + other);
    }

    public int value() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
