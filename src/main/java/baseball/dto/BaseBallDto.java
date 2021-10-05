package baseball.dto;

public class BaseBallDto {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public BaseBallDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
}
