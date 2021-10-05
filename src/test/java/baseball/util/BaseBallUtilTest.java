package baseball.util;

import baseball.dto.BaseBallDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"2:true", "4:true", "6:true"}, delimiter = ':')
    void getInputStrToNums_입력_문자열_배열_변환_테스트(int number, boolean expected) {
        int[] nums = BaseBallUtil.getInputStrToNums("246");
        Set<Integer> numSet = new HashSet<>();
        int i = 0;
        while(numSet.size()< nums.length){
            numSet.add(nums[i]);
            i++;
        }
        assertThat(numSet.contains(number)).isEqualTo(expected);
    }

    @Test
    void getRandomGenerateNum_랜덤_생성_테스트() {
        assertThat(BaseBallUtil.getRandomGenerateNum()).hasSize(3);
    }

    @Test
    void checkNum_랜덤_입력_야구결과체크_테스트() {
        int[] randomNum = {1, 2, 3};
        int[] inputNum = {1, 2, 3};
        BaseBallDto baseBallDto = BaseBallUtil.checkNum(randomNum, inputNum);
        assertThat(baseBallDto.getStrike()).isEqualTo(3);
        assertThat(baseBallDto.getBall()).isZero();
    }

    @Test
    void getCheckStrike_스트라이크_체크_테스트() {
        assertThat(BaseBallUtil.getCheckStrike(9, 9)).isEqualTo(1);
    }

    @Test
    void getCheckBall_볼_체크_테스트() {
        int[] randomNum = {1, 2, 3};
        assertThat(BaseBallUtil.getCheckBall(randomNum, 0, 3)).isEqualTo(1);
    }

    @Test
    void updateMessage_스트라이크_볼_결과메세지_테스트() {
        assertThat(BaseBallUtil.updateMessage(3, 0)).isEqualTo("3스트라이크");
        assertThat(BaseBallUtil.updateMessage(0, 3)).isEqualTo("3볼");
        assertThat(BaseBallUtil.updateMessage(1, 2)).isEqualTo("1스트라이크 2볼");
        assertThat(BaseBallUtil.updateMessage(0, 0)).isEqualTo("낫싱");
    }

    @Test
    void charactersCheckNum() {
        int[] nums = BaseBallUtil.getInputStrToNums("qwe");
        assertThat(BaseBallUtil.charactersCheckNum(nums)).isFalse();
    }

    @Test
    void sizeCheckNum() {
        int[] nums = BaseBallUtil.getInputStrToNums("1234");
        assertThat(BaseBallUtil.sizeCheckNum(nums)).isFalse();
    }

    @Test
    void duplicateNum() {
        int[] nums = BaseBallUtil.getInputStrToNums("122");
        assertThat(BaseBallUtil.duplicateNum(nums)).isFalse();
    }
}
